import ReactECharts from "echarts-for-react";

function JobAdvertisementRate(props) {
  const option = {
    title: {
      text: "Job Advertisement Rate",
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
        data: [5, 6, 7, 3, 5, 4, 6, 8, 12, 24, 22, 32],
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

export default JobAdvertisementRate;
