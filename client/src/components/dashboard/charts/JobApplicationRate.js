import ReactECharts from "echarts-for-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobApplication } from "../../../redux/reducers/JobApplication/actions";

function JobApplicationRate(props) {
  const dispatch = useDispatch();

  const { jobApplication } = useSelector((state) => state.jobApplication);

  useEffect(() => {
    dispatch(allJobApplication());
  }, []);

  const monthList = [
    ...new Set(
      jobApplication.map((data) => {
        let date = new Date(data.jobAppliedDate);

        let month = date.toLocaleString("default", { month: "short" });
        return month;
      })
    ),
  ];

  const rateData = monthList.map((x) => {
    return {
      month: x,
      value: 0,
    };
  });

  rateData.forEach((element) => {
    let filterData = jobApplication.filter((x) => {
      let date = new Date(x.jobAppliedDate);
      let month = date.toLocaleString("default", { month: "short" });
      return month === element.month;
    });

    element.value = filterData.length;
  });

  const sortedRateData = [
    "jan",
    "feb",
    "mar",
    "apr",
    "may",
    "jun",
    "jul",
    "aug",
    "sep",
    "oct",
    "nov",
    "dec",
  ].map((x) => {
    let currentData = rateData.filter((y) => {
      return y.month.toLowerCase() === x;
    });
    return currentData[0]
      ? currentData[0]
      : {
          month: x,
          value: 0,
        };
  });

  const option = {
    title: {
      text: "Job Application Rate",
      subtext: "per month",
      left: "center",
    },
    xAxis: {
      type: "category",
      data: sortedRateData.map((x) => x.month),
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        data: sortedRateData.map((x) => x.value),
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
