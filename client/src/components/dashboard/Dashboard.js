import React from "react";
import ReactECharts from "echarts-for-react";
import NumberOfStudents from "./charts/NumberOfStudents";
import NumberOfJobs from "./charts/NumberOfJobs";
import JobSearchTime from "./charts/JobSearchTime";
import TagPieChart from "./charts/TagPieChart";
import TagPerLocation from "./charts/TagPerLocation";
import NumberOfStudentsPerCity from "./charts/NumberOfStudentsPerCity";
import JobApplicationRate from "./charts/JobAdvertisementRate";
import JobAdvertisementRate from "./charts/JobAdvertisementRate";
import TopCompanies from "./charts/TopCompanies";
import StudentDepartment from "./charts/StudentDepartment";

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
          <NumberOfStudentsPerCity />
        </div>

        <div className="col-md-6">
          <TagPieChart />
        </div>
      </div>
      <div className="row">
        <div className="col-md-12">
          <TagPerLocation />
        </div>
      </div>

      <div className="row">
        <div className="col-md-6">
          <JobApplicationRate />
        </div>
        <div className="col-md-6">
          <JobAdvertisementRate />
        </div>
      </div>

      <div className="row">
        <div className="col-md-6">
          <TopCompanies />
        </div>
        <div className="col-md-6">
          <StudentDepartment />
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
