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
    'deleteUrl': '/',
    'detailUrl': '/'
}

export default function FacultyList() {
    return (
        <>
            Faculty List
            <div className="list-table">
                <TableMain listParams={listParams}></TableMain>
            </div>
        </>

    )

}