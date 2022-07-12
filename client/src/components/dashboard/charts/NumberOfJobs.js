import ReactECharts from "echarts-for-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../../redux/reducers/JobAdvertisement/actions";

function NumberOfJobs() {
  const dispatch = useDispatch();

  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const stateList = [
    ...new Set(jobAdvertisement.map((data) => data.address?.state)),
  ];

  const jobAdvertisementData = stateList.map((x) => {
    return {
      name: x,
      value: 0,
    };
  });

  jobAdvertisementData.forEach((element) => {
    let filterData = jobAdvertisement.filter(
      (x) => x.address?.state == element.name
    );

    element.value = filterData.length;
  });

  //   [].concat(...jobAdvertisement).map;

  const option = {
    title: {
      text: "Number Of Jobs",
      subtext: "Per Location",
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
        data: jobAdvertisementData,
        // data: [
        //   { value: 10, name: "Iowa (10)" },
        //   { value: 20, name: "Chicago (20)" },
        //   { value: 30, name: "New York (30)" },
        //   { value: 40, name: "San Franscisco (40)" },
        //   { value: 80, name: "Texas (80)" },
        // ],
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
    <>
      {/* {JSON.stringify(jobAdvertisement)} */}
      <div className="card">
        <ReactECharts
          option={option}
          notMerge={true}
          lazyUpdate={true}
          theme={"theme_name"}
          style={{ height: "500px", width: "100%" }}
        />
      </div>
    </>
  );
}

export default NumberOfJobs;
