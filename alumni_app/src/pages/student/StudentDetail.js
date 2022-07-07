import React from "react";
import { useParams } from "react-router";

export default function StudentDetail(props) {
    const { id } = useParams();
    return (
        <div>
            {id}
            <br></br>
            Student Detail:
            <br></br>
            <label>Name: </label>
            <label>Name: </label>
            <br></br>
            <label>Name: </label>
            <label>Name: </label>
            <br></br>
            <label>Name: </label>
            <label>Name: </label>
            <br></br>
            <label>Name: </label>
            <label>Name: </label>
        </div>
    )

}