import React from "react";
import TableMain from "../../common/TableMain";



const listParams = {
    'showDetail': true,
    'showEdit': false,
    'showDelete': true,
    'showAddComment': false,
    'dataUrl': '/faculties',
    'addCommentUrl': '//',
    'editUrl': '',
    'deleteUrl': '/faculties/',
    'detailUrl': '/'
}

export default function FacultyList() {
    return (
        <>

            <span className="badge rounded-pill bg-primary"> Faculty List </span>
            <div className="list-table">
                <TableMain listParams={listParams}></TableMain>
            </div>
        </>

    )

}