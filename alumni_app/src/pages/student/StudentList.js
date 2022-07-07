import React from "react";
import TableMain from "../../common/TableMain";

export default function StudentList() {
    return (
        <>
            Student List
            <div className="list-table">
                <TableMain dataUrl={'/todos'}></TableMain>
            </div>
        </>

    )
}