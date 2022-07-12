import React from "react";
import ReactECharts from "echarts-for-react";
import NumberOfStudents from "./charts/NumberOfStudents";
import NumberOfJobs from "./charts/NumberOfJobs";
import JobSearchTime from "./charts/JobSearchTime";
import TagPieChart from "./charts/TagPieChart";
import Last10Appliedjobs from "./Last10AppliedJob";
import Last10JobAdvertisement from "./Last10JobAdvertisement";

function Dashboard() {
  const option = {};

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6">
          <NumberOfJobs />
        </div>

        <div className="col-md-6">
          <JobSearchTime />
        </div>
      </div>

      <div className="row">
        <div className="col-md-6">
          <NumberOfStudents />
        </div>

        <div className="col-md-6">
          <TagPieChart />
        </div>
      </div>
      <div className="row">
        <div className="col-md-6">
          <Last10Appliedjobs />
        </div>

        <div className="col-md-6">
          <Last10JobAdvertisement />
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
