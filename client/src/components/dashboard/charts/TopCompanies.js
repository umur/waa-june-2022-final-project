import ReactECharts from "echarts-for-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

import { getJobHistoryList } from "../../../redux/reducers/JobHistory/actions";

function TopCompanies() {
  const dispatch = useDispatch();

  const { jobHistory } = useSelector((state) => state.jobHistory);

  useEffect(() => {
    dispatch(getJobHistoryList());
  }, []);

  const companyList = [
    ...new Set(
      jobHistory.map((data) => {
        return data.companyName;
      })
    ),
  ];

  const companyListData = companyList.map((x) => {
    return {
      name: x,
      value: 0,
    };
  });

  companyListData.forEach((element) => {
    let filterData = jobHistory.filter((x) => x.companyName == element.name);

    element.value = filterData.length;
  });

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
        radius: "60%",
        data: companyListData,
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
        style={{ height: "800px", width: "100%" }}
      />
    </div>
  );
}

export default TopCompanies;
