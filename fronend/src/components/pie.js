import React, { PureComponent } from "react";
import ReactEcharts from "echarts-for-react";

class Pie extends PureComponent {
  getOption = () => ({
    title: {
      text: "Average time spent",
      subtext: " to find a job per gpa range",
      x: "center"
    },
    tooltip: {
      trigger: "item",
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
      orient: "vertical",
      left: "left",
      data: ["4.0", "3.75", "3.5", "3.0", "2.75"]
    },
    series: [
      {
        name: "Find student by GPA",
        type: "pie",
        radius: "55%",
        center: ["50%", "60%"],
        animationDuration: 5000,
        data: [
          { value: 335, name: "4.0" },
          { value: 310, name: "3.75" },
          { value: 234, name: "3.5" },
          { value: 135, name: "3.0" },
          { value: 1548, name: "2.75" }
        ],
        itemStyle: {
          emphasis: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: "rgba(0, 0, 0, 0.5)"
          }
        }
      }
    ]
  });

  render() {
    return (
      <ReactEcharts
        option={this.getOption()}
        style={{ height: "400px", width: "100%" }}
      />
    );
  }
}
export default Pie;
