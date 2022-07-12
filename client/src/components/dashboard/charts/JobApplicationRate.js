import ReactECharts from "echarts-for-react";

function JobApplicationRate(props) {
  const option = {
    title: {
      text: "Job Application Rate",
      subtext: "per month",
      left: "center",
    },
    xAxis: {
      type: "category",
      data: [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
      ],
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        data: [3, 4, 6, 8, 2, 5, 7, 6, 9, 23, 5, 6],
        type: "line",
      },
    ],
  };
  return (
    <div className="card">
      <ReactECharts
        option={option}
        notMerge={true}
        lazyUpdate={true}
        theme={"theme_name"}
        style={{ height: "500px", width: "100%" }}
      />
    </div>
  );
}

export default JobApplicationRate;
