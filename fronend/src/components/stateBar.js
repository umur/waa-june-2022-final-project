import React, { PureComponent } from "react";
import ReactEcharts from "echarts-for-react";

class StateBar extends PureComponent {
  getOption = () => ({
    title: {
      text: "Number of students per state"
    },
    tooltip: {
      trigger: "axis"
    },
    legend: {
      data: ["IA", "TX", "CA", "NY", "VA"]
    },
    grid: {
      left: "3%",
      right: "4%",
      bottom: "3%",
      containLabel: true
    },
    toolbox: {
      feature: {
        saveAsImage: {}
      }
    },
    xAxis: {
      type: "category",
      data: ["Cat-0", "Cat-1", "Cat-2", "Cat-3", "Cat-4", "Cat-5", "Cat-6"]
    },
    yAxis: {
      type: "value"
    },
    series: [
      {
        name: "IA",
        type: "bar",
        data: [120, 132, 101, 134, 90, 230, 210],
        animationDuration: 5000
      },
      {
        name: "TX",
        type: "line",
        data: [220, 182, 191, 234, 290, 330, 310],
        animationDuration: 5000
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
export default StateBar;
