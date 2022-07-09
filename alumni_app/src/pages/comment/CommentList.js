import { AddComment } from "@material-ui/icons";
import React, { useEffect } from "react";
import { Button } from "react-bootstrap";
import { useNavigate, useParams } from "react-router";
import TableMain from "../../common/TableMain";
import { getRequest } from "../../setup/fetch-manager/FetchGateway";


export default function CommentList() {


    let navigate = useNavigate();
    const { id } = useParams();

    // const [commentState, setCommentState] = {};
    // const fetchComment = async () => {
    //     let response = await getRequest('/comments' + id);
    //     setCommentState(response);
    // }

    // useEffect(() => {
    //     fetchComment();
    // }, [])

    const listParams = {
        'showDetail': true,
        'showEdit': false,
        'showDelete': false,
        'showAddComment': false,
        'dataUrl': '/comments/student/' + id,
        'addCommentUrl': '',
        'editUrl': '',
        'deleteUrl': '',
        'detailUrl': ''
    }

    return (
        <>
            <Button onClick={() => { navigate('/AddComment/' + id) }}>Add Comment</Button>
            <div className="list-table">
                <TableMain listParams={listParams} ></TableMain>
            </div>

        </>
    )
}