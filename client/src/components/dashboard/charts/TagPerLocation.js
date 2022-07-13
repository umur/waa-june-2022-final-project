import ReactECharts from "echarts-for-react";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../../redux/reducers/JobAdvertisement/actions";

function TagPerLocation() {
  const dispatch = useDispatch();

  const { jobAdvertisement } = useSelector((state) => state.jobAdvertisement);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const stateList = [
    ...new Set(jobAdvertisement.map((data) => data.address?.state)),
  ];

  const tagListCollect = [];
  jobAdvertisement.forEach((job) => {
    job.tags?.forEach((tag) => {
      tagListCollect.push(tag.tagName);
    });
  });

  const tagList = [...new Set(tagListCollect)];

  const jobPositionObj = tagList.map((data) => ({
    name: data,
    type: "bar",
    stack: "total",
    label: {
      show: true,
    },
    emphasis: {
      focus: "series",
    },
    data: [],
  }));

  stateList.forEach((x) => {
    jobPositionObj.forEach((y) => {
      const tagPerLocation = jobAdvertisement.filter((data) => {
        let state = data.address?.state;
        let tags = data.tags.filter((tag) => tag.tagName == y.name);

        return state == x && tags.length;
      });
      y.data.push(tagPerLocation.length);
    });
  });

  // jobAdvertisementData.forEach((element) => {
  //   let filterData = jobAdvertisement.filter(
  //     (x) => x.address?.state == element.name
  //   );

  //   element.value = filterData.length;
  // });

  const option = {
    tooltip: {
      trigger: "axis",
      axisPointer: {
        // Use axis to trigger tooltip
        type: "shadow", // 'shadow' as default; can also be 'line' or 'shadow'
      },
    },
    legend: {},
    grid: {
      left: "3%",
      right: "4%",
      bottom: "3%",
      containLabel: true,
    },
    xAxis: {
      type: "value",
    },
    yAxis: {
      type: "category",
      data: stateList,
    },
    series: jobPositionObj,
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

export default TagPerLocation;
