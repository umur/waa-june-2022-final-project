import { AddComment } from "@material-ui/icons";
import React from "react";
import { Button } from "react-bootstrap";
import { useNavigate, useParams } from "react-router";


export default function CommentList() {
    let navigate = useNavigate();
    const { id } = useParams();
    return (
        <>
            <Button onClick={() => { navigate('/AddComment/' + id) }}>Add Comment</Button>
        </>
    )
}