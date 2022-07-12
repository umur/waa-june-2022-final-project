import ReactEcharts from "echarts-for-react"; 
import React, { useState } from 'react'

import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import student from '../../service/student';

function RoseChart (){
  const currentUser = useSelector(state => state.user)
  const [stateList, setStateList] = useState([])

  useEffect(() => {
    if (currentUser?.id) {
      student.findAll().then(resp => {
        
          setStateList(resp.data.map(item=> item.address.city) )
         // setFilteredList(resp.address)
          // setIsLoaded(true)
      }).catch(err => {
          console.log(err);
      })
  }
}, [])

const uniqueState = [...new Set(stateList)];

const stateCounts = {};
stateList.forEach(function (x) { stateCounts[x] = (stateCounts[x] || 0) + 1; });

const a=Object.values(stateCounts);
const b=Object.values(uniqueState);

const merge=[];
for(let i=0; i<b.length; i++){
  merge.push({value:a[i],name:b[i]});
}
console.log(merge)  

    const option = {
        title: {
            text: 'Number of students per city',
            left: 'center'
          },
          tooltip: {
            trigger: 'item'
          },
          legend: {
            orient: 'vertical',
            left: 'left'
          },
          series: [
            {
              name: 'Access From',
              type: 'pie',
              radius: '50%',
             
              data:merge,
              emphasis: {
                itemStyle: {
                  shadowBlur: 50,
                  shadowOffsetX: 0,
                  shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
              }
            }
          ]
      }; 
      return <ReactEcharts option={option} />;
}

export default RoseChart;