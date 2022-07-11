import React, { useState } from "react";
import { useParams } from "react-router";
import TableMain from "../../common/TableMain";

export default function GetJobList() {
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
    detailUrl: "/jobs/" + id + "/",
  };
  debugger;
  const [listParamsD, setParams] = useState(listParams);

  return (
    <>
      <span className="badge rounded-pill bg-primary"> Posted Job List </span>
      <div className="list-table">
        <TableMain listParams={listParamsD}></TableMain>
      </div>
    </>
  );
}
