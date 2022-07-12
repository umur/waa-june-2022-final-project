import PieChart from "../chart/PieChart";
import React, { useEffect, useState } from "react";
import BarChart from "../chart/BarChart";
import TopJobAdd from "../chart/TopJobAdd";
import AutoCompleteSelect from "../../common/AutoCompleteSelect";
import Container from "@material-ui/core/Container";

export default function HomePage() {
  const [dataUrlByState, setDataUrlByState] = useState(
    '/reports/studentByCity/""'
  );

  const [urlByState, setUrlByState] = useState('/jobs/getByStateTag/""');

  const setValue = (name, value) => {
    let title = "undefined";
    if (value[0] != null) {
      title = value[0].title;
    }
    switch (name) {
      case "state":
        setDataUrlByState("/reports/studentByCity/" + title);
        break;
    }
  };

  const setAddress = (name, value) => {
    let title = "undefined";
    if (value[0] != null) {
      title = value[0].title;
    }
    switch (name) {
      case "state":
        setUrlByState("/jobs/getByStateTag/" + title);
        break;
    }
  };

  return (
    <>
      <div className="border">
        <div className="row">
          <div className="col-6">
            <BarChart dataUrl={"/reports/jobByState"}></BarChart>
          </div>
          <div className="col-6 mt-2">
            <PieChart dataUrl={"/reports/studentByState"}
              subtext={"Student statistics"}
              name={"Student per department"}
              title={"Student Data"}
            ></PieChart>
          </div>
          <div className="col-12 mt-2">
            <TopJobAdd></TopJobAdd>
          </div>
          <div className="col-6 mt-2">
            <AutoCompleteSelect
              name="state"
              onChange={(value) => setValue("state", value)}
              isMultiSelect={false}
              label={"State"}
              placeholder={"Eg. iowa, california"}
              dataUrl="/reports/state"
            ></AutoCompleteSelect>
            <PieChart
              dataUrl={dataUrlByState}
              subtext={"City statistics"}
              name={"Cites per State"}
              title={"City Data"}
            ></PieChart>
          </div>
          <div className="col-6 mt-2">
            <PieChart
              dataUrl={"/reports/facultyByDepartment"}
              subtext={"Faculty statistics"}
              name={"Faculty per department"}
              title={"Faculty Data"}
            ></PieChart>
          </div>

          <div className="col-6 mt-2">
            <PieChart
              dataUrl={"/jobs/getByTags"}
              subtext={"Tags statistics"}
              name={"Jobs as per tags"}
              title={"Jobs as per Tags"}
            ></PieChart>
          </div>
          <div className="col-6 mt-2">
            <AutoCompleteSelect
              name="state"
              onChange={(value) => setAddress("state", value)}
              isMultiSelect={false}
              label={"State"}
              placeholder={"Eg. iowa, california"}
              dataUrl="/reports/state"
            ></AutoCompleteSelect>
            <PieChart
              dataUrl={urlByState}
              subtext={"Tags with location"}
              name={"Tags with location"}
              title={"Tags with location"}
            ></PieChart>
          </div>
        </div>
      </div>
    </>
  );
}
