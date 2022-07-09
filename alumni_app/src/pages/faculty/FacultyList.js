import React from "react";
import TableMain from "../../common/TableMain";

export default function FacultyList() {
    return (
        <>
            Faculty List
            <div className="list-table">
                <TableMain dataUrl={'/faculties'}></TableMain>
            </div>
        </>

    )

}