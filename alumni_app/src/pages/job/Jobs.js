import React from "react";
import Button from '@material-ui/core/Button';
import { useNavigate } from "react-router";
import TableMain from "../../common/TableMain";

export default function Jobs() {
    const navigate = useNavigate();
    return (
        <>


            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button variant="contained" color="primary" onClick={() => (navigate('/Jobs/newJob'))}>
                    Add Job
                </Button>
            </div>

            Job List
            <div className="list-table">
                <TableMain dataUrl={'/jobs'} detailUrl={'/StudentDetails/'} editUrl={'/Edit'} deleteUrl={'/StudentDelete/'} addComment={true} ></TableMain>
            </div>
        </>
    )
}