import ReactCharts from "echarts-for-react";
const StudentPerFaculty = (props) => {
  const option = {
    title: {
      text: "Number Of Student",
      subtext: "Per Faculty",
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
        name: "Faculty",
        type: "pie",
        radius: "50%",
        data: [{}],
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
};

export default StudentPerFaculty;
