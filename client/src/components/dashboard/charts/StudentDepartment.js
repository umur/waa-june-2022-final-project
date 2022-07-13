import ReactECharts from "echarts-for-react";

function StudentDepartment() {
  const option = {
    title: {
      text: "Number Of Student",
      subtext: "Per department",
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
          { value: 500, name: "Compro" },
          { value: 50, name: "MBA" },
          { value: 100, name: "MSD" },
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

export default StudentDepartment;
