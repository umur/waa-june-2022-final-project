import React from "react";
import Button from '@material-ui/core/Button';
import { useNavigate } from "react-router";
import TableMain from "../../common/TableMain";


const listParams = {
    'showDetail': true,
    'showEdit': false,
    'showDelete': true,
    'showAddComment': false,
    'dataUrl': '/jobs',
    'addCommentUrl': '//',
    'editUrl': '',
    'deleteUrl': '/',
    'detailUrl': '/'
}

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
                <TableMain listParams={listParams}></TableMain>
            </div>
        </>
    )
}