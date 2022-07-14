import ReactEcharts from "echarts-for-react"; 

import React, { useState } from 'react'

import { useEffect } from 'react';
import { useSelector } from 'react-redux';
import student from '../../service/student';


function DoughnutChart(){

  const [studentList, setStudentList] = useState([]);
  const [searchQuery, setSearchQuery] = useState("")

    const currentUser = useSelector(state => state.user)
    const [stateList, setStateList] = useState([])
    const [stateaddress, setStateListaddress] = useState([])

    useEffect(() => {
      if (currentUser?.id) {
          student.findAll().then(resp => {
              setStudentList(resp.data)
              setStateList(resp.data.map(item=> item.address.state) )
              setStateListaddress(resp.data.map(item=> item.address) )
             // setFilteredList(resp.address)
              // setIsLoaded(true)
          }).catch(err => {
              console.log(err);
          })
      }
  }, [])
 
   // console.log(stateaddress);

 const uniqueState = [...new Set(stateList)];
 const stateCounts = {};
    stateList.forEach(function (x) { stateCounts[x] = (stateCounts[x] || 0) + 1; });

    // console.log(uniqueState);
    // console.log(stateCounts);

    const a=Object.values(stateCounts);
    const b=Object.values(uniqueState);
    
   const merge=[];
    for(let i=0; i<b.length; i++){
      merge.push({value:a[i],name:b[i]});
    }
    
    //console.log(merge)  
   

    const option = {
      title: {
        text: 'Number of students per state.',
        left: 'center'
      },
        tooltip: {
            trigger: 'item'
          },
          legend: {
            bottom: '0%',
            left: 'center'
          },
          series: [
            {
              name: 'Access From',
              type: 'pie',
              radius: ['40%', '70%'],
              avoidLabelOverlap: false,
              itemStyle: {
                borderRadius: 10,
                borderColor: '#fff',
                borderWidth: 2
              },
              label: {
                show: false,
                position: 'center'
              },
              emphasis: {
                label: {
                  show: true,
                  fontSize: '40',
                  fontWeight: 'bold'
                }
              },
              labelLine: {
                show: false
              },
              
              data:
              merge
            }
          ]
      }; 
      return <ReactEcharts option={option} />;
}
export default DoughnutChart;