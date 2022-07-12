import React from 'react';

import { useState, useEffect, useRef, useCallback } from 'react'
import ReactEcharts from "echarts-for-react"; 
import job from '../../service/job';
import { useSelector } from 'react-redux'

// import { useState, useEffect, useRef, useCallback } from 'react'
// import { useSelector } from 'react-redux'
// import job from '../../service/job'

function DoughnutChart(){
  // const currentUser = useSelector(state => state.user)
  // const [jobList, setJobList] = useState([])
  // const [isLoaded, setIsLoaded] = useState(false)
  // const [filteredList, setFilteredList] = useState([])


  //   useEffect(() => {
  //     if (currentUser?.id) {
  //         job.findAll().then(resp => {
  //             setJobList(resp.data.map(item=>item.state))
  //             // setFilteredList(resp.data)
  //             // setIsLoaded(true)
  //         }).catch(err => {
  //             console.log(err);
  //         })   
  //     }
  // }, [])


  const [jobList, setJobList] = useState([])
  const [stateList, setStateList] = useState([])
  const [titleList, setTitleList] = useState([])
  const currentUser = useSelector(state => state.user)

  useEffect(() => {
    if (currentUser?.id) {
        job.findAll().then(resp => {

            setJobList(resp.data)
            setStateList(resp.data.map(item=> item.salary) )
            setTitleList(resp.data.map(item=> item.title) )
           
        }).catch(err => {
            console.log(err);
        })
    }
}, [])
  console.log(stateList);
  console.log(jobList);


  const stateCounts = {};
     stateList.forEach(function (x) { stateCounts[x] = (stateCounts[x] || 0) + 1; });

  // const uniqueState = [...new Set(stateList)];

  // const stateCounts = {};
  // stateList.forEach(function (x) { stateCounts[x] = (stateCounts[x] || 0) + 1; });

 // console.log(stateCounts);
 const option = {
  title: {
    text: 'Salary of jobs position',
    left: 'center'
  },
  // tooltip: {
  //   trigger: 'axis',
  //   axisPointer: {
  //     type: 'shadow'
  //   }
  // },
  // grid: {
  //   left: '3%',
  //   right: '4%',
  //   bottom: '3%',
  //   containLabel: true
  // },
  xAxis: [
    {
      type: 'category',
      data: titleList,
      axisTick: {
        alignWithLabel: true
      },
      axisLabel: { interval: 0, rotate: 18 }
    }
  ],
  yAxis: [
    {
      type: 'value'
    }
  ],
  series: [
    {
      // name: 'Direct',
       type: 'bar',
      // barWidth: '60%',
      data: Object.values(stateList),
    }
  ]
  }; 
  return <ReactEcharts option={option} />;
}
export default DoughnutChart;