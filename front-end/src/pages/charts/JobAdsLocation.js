import React from "react";
import { useState, useEffect, useRef, useCallback } from 'react'
import ReactEcharts from "echarts-for-react"; 
import job from '../../service/job';
import { useSelector } from 'react-redux'


function BarChart (){
  
  const [jobList, setJobList] = useState([])
  const [stateList, setStateList] = useState([])
  const currentUser = useSelector(state => state.user)

  useEffect(() => {
    if (currentUser?.id) {
        job.findAll().then(resp => {
            setJobList(resp.data)
            setStateList(resp.data.map(item=> item.states) )
            // setFilteredList(resp.data)
            // setIsLoaded(true)
        }).catch(err => {
            console.log(err);
        })
    }
}, [])

     const uniqueState = [...new Set(stateList)];

    const stateCounts = {};
    stateList.forEach(function (x) { stateCounts[x] = (stateCounts[x] || 0) + 1; });
    // console.log(Object.values(stateCounts));

    const option = {
      title: {
        text: 'Number of job ads per location ',
        left: 'center'
      },
        xAxis: {
          type: 'category',
          data: uniqueState
          // data: ['LA', 'IO', 'NC', 'TX', 'FL', 'NC', 'GA','OK']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: Object.values(stateCounts),
            type: 'bar'
          }
        ]
      }; 
      return <ReactEcharts option={option} />;
}

export default BarChart;