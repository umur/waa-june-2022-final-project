import React from "react";
import TableMain from "../../common/TableMain";


const listParams = {
    'showDetail': true,
    'showEdit': true,
    'showDelete': true,
    'showAddComment': true,
    'dataUrl': '/students',
    'addCommentUrl': '/Comments/',
    'editUrl': '',
    'deleteUrl': '/StudentDelete',
    'detailUrl': '/StudentDetails'
}

export default function StudentList() {
    return (
        <>
            Student List
            <div className="list-table">
                <TableMain listParams={listParams} ></TableMain>
            </div>
        </>

    )
}