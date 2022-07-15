import React, { useState, useEffect } from "react";
import ReactEcharts from "echarts-for-react"; 
import { TagCloud } from 'react-tagcloud';
import axios from "axios";

import Pie from "./pie";
import StateBar from "./stateBar";
import ApiService from "../services/ApiService";

let c1 = [];
let c2 = [];
const Dashboard = () => {
    
  const [studentsByState, setStudentsByState] = useState([]);
  
  useEffect(() => {
    // axios
    //   .get("http://localhost:8081/api/v1/faculty/stat")
    //   .then(({ data }) => {
    //     setStudentsByState(data);
    //     data.map((res,i) =>{
    //       console.log(res);
    //       return res;
    //     })
    //   })
    //   .catch((error) => {
    //     console.log(error);
    //   });

    ApiService.getAllData(ApiService.STAT_DATA).then((res) => {
      //this.setState({ jobs: res.data.jobList });
      setStudentsByState(res.data);
      console.log(res.data);
      console.log(res.data.jobByState);
      const sampleJSON = res.data.jobByState;

      // const resss = Object.values(sampleJSON).map((key, i) => (
      //   // <p key={i}>
      //   //   <span>Key Name: {key}</span>
      //   //   <span>Value: {sampleJSON.object[key]}</span>
      //   // </p>

      //   console.log(sampleJSON.object[key])
      // ));
      // console.log(resss);

      c1 = Object.keys(sampleJSON);
      console.log(c1);

      c2 = Object.values(sampleJSON);
      console.log(c2);

      // res.data.jobByState.map((d, i) => {
      //   console.log(d.key);
      //   return d;
      // })
    });
  }, []);
  
  // const DataTable = () => {
  //   return studentsByState.map((res, i) => {
  //     return <StudentTableRow obj={res} key={i} />;
  //   });
  // };

    const option = {
      xAxis: {
        type: 'category',
        data: c1
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: c2,
          type: 'bar'
        }
      ]
    }; 

    const data = [
      { value: 'jQuery', count: 25 },
      { value: 'MongoDB', count: 18 },
      { value: 'JavaScript', count: 38 },
      { value: 'React', count: 30 },
      { value: 'Nodejs', count: 28 },
      { value: 'Express.js', count: 25 },
      { value: 'HTML5', count: 33 },
      { value: 'CSS3', count: 20 },
      { value: 'Webpack', count: 22 },
      { value: 'Babel.js', count: 7 },
      { value: 'ECMAScript', count: 25 },
      { value: 'Jest', count: 15 },
      { value: 'Mocha', count: 17 },
      { value: 'React Native', count: 27 },
      { value: 'Angular.js', count: 30 },
      { value: 'TypeScript', count: 15 },
      { value: 'Flow', count: 30 },
      { value: 'NPM', count: 11 },
    ]

    // custom renderer is function which has tag, computed font size and
    // color as arguments, and returns react component which represents tag
    const customRenderer = (tag, size, color) => (
      <span
        key={tag.value}
        style={{
          animation: 'blinker 3s linear infinite',
          animationDelay: `${Math.random() * 2}s`,
          fontSize: `${size / 2}em`,
          border: `2px solid ${color}`,
          margin: '3px',
          padding: '3px',
          display: 'inline-block',
          color: 'black',
        }}
      >
        {tag.value}
      </span>
    )


    return (

      <div className="container">
        <h1>Dashboard</h1>
        <p>ECharts to create live charts for dashboards:</p>
        <div className="panel-group">
          <div className="panel panel-default">
            <div className="panel-heading">Number of job advertisements per location.</div>
            <div className="panel-body">
            <ReactEcharts option={option} />
            </div>
          </div>
          <div className="panel panel-default">
            <div className="panel-heading">Number of students per state.</div>
            <div className="panel-body"><StateBar /></div>
          </div>
          <div className="row">
            <div className="col-md-6">
                <div className="panel panel-default">
                  <div className="panel-heading">Tags</div>
                  <div className="panel-body"><TagCloud tags={data} minSize={1} maxSize={5} style={{ width: 500, textAlign: 'left' }} renderer={customRenderer} /></div>
                </div>
              </div>
              <div className="col-md-6">
                <div className="panel panel-default">
                  <div className="panel-heading">Tags by location</div>
                  <div className="panel-body"><TagCloud tags={data} minSize={1} maxSize={5} style={{ width: 500, textAlign: 'left' }} renderer={customRenderer} /></div>
                </div>
              </div>
          </div>
          
          <div className="col-md-6">
            <div className="panel panel-default">
            <div className="panel-heading">Average time spent to find a job per gpa range.</div>
            <div className="panel-body"> <Pie /></div>
          </div>
          </div>          

          
          
        </div>
      </div>    
      
    );

  };
  
  export default Dashboard;
  