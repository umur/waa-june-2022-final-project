import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import { getRequest } from "../../setup/fetch-manager/FetchGateway";

export const ShowComments = () => {

    const { id } = useParams();
    const initialState = { comments: [] };

    const [commentState, setCommentState] = useState(initialState);
    const fetchComments = async () => {
        let response = await getRequest('/comments' + id)
        setCommentState(response);
    }

    useEffect(() => {
        fetchComments();
    }, [])

    return (
        <div>

        </div>
    )
}