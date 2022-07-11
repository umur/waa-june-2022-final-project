import React, { useState } from "react";
import { useParams } from "react-router";
import TableMain from "../../common/TableMain";

export default function ViewApplicant() {
  const { id } = useParams();
  const listParams = {
    showDetail: true,
    showEdit: true,
    showDelete: true,
    showAddComment: false,
    dataUrl: "/jobs/" + id,
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
