import React from "react";
import TableMain from "../../common/TableMain";

export default function StudentList() {
    return (
        <>
            Student List
            <div className="list-table">
                <TableMain dataUrl={'/students'} detailUrl={'/StudentDetails/'} editUrl={'/Edit'} deleteUrl={'/StudentDelete/'} addComment ={true} ></TableMain>
            </div>
        </>

    )
}