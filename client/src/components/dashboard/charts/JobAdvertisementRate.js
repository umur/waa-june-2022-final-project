import ReactECharts from "echarts-for-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../../redux/reducers/JobAdvertisement/actions";

function JobAdvertisementRate(props) {
  const dispatch = useDispatch();

  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const monthList = [
    ...new Set(
      jobAdvertisement.map((data) => {
        let date = new Date(data.vacancyOpeningDate);

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
    let filterData = jobAdvertisement.filter((x) => {
      let date = new Date(x.vacancyOpeningDate);
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
      text: "Job Advertisement Rate",
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

export default JobAdvertisementRate;
