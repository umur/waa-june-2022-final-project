import ReactECharts from "echarts-for-react";

function TopCompanies() {
  const option = {
    title: {
      text: "Top Companies ",
      subtext: "based on student work history",
      left: "center",
    },
    tooltip: {
      trigger: "item",
    },
    legend: {
      orient: "vertical",
      left: "left",
    },
    series: [
      {
        name: "Location",
        type: "pie",
        radius: "50%",
        data: [
          { value: 10, name: "Google" },
          { value: 50, name: "Apple" },
          { value: 100, name: "Microsoft" },
          { value: 200, name: "Walmart" },
          { value: 40, name: "KForce" },
        ],
        emphasis: {
          itemStyle: {
            shadowBlur: 10,
            shadowOffsetX: 0,
            shadowColor: "rgba(0, 0, 0, 0.5)",
          },
        },
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

export default TopCompanies;
