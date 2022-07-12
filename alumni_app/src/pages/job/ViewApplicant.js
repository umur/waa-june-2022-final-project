import React, { useState } from "react";
import { useParams } from "react-router";
import TableMain from "../../common/TableMain";

export default function ViewApplicant() {
  const { studentID, jobID } = useParams();

  const listParams = {
    showDetail: false,
    showEdit: false,
    showDelete: false,
    showAddComment: false,
    dataUrl: "/jobs/apply/by/1",
    addCommentUrl: "//",
    editUrl: "",
    deleteUrl: "/",
    detailUrl: "/",
  };
  debugger;
  const [listParamsD, setParams] = useState(listParams);

  return (
    <>
      <span className="badge rounded-pill bg-primary"> Applicant Details </span>
      <div className="list-table">
        <TableMain listParams={listParamsD}></TableMain>
      </div>
    </>
  );
}
