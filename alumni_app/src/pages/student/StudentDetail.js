import React, { useEffect } from "react";
import { useParams } from "react-router";


import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import { getRequest } from "../../setup/fetch-manager/FetchGateway";
import { useState } from "react";


export default function StudentDetail(props) {
    const { id } = useParams();

    const [studentState, setStudentState] = useState();

    const fetchData = async () => {
        let response = await getRequest('/students/' + id);
        setStudentState(response);
    }

    useEffect(() => {
        fetchData();
    }, [])

    let displayData = [];
    if (studentState != undefined) {
        displayData.push(
            <div className="pointer">
                <span href="#" className="list-group-item list-group-item-action list-group-item-primary">First Name : {studentState.firstName}</span>
                <span href="#" className="list-group-item list-group-item-action list-group-item-success">Last Name : {studentState.lastName}</span>
                <span href="#" className="list-group-item list-group-item-action list-group-item-warning">Email : {studentState.email}</span>
                <span href="#" className="list-group-item list-group-item-action list-group-item-danger">State : {studentState.state}</span>
                <span href="#" className="list-group-item list-group-item-action list-group-item-info">City : {studentState.city}</span>
            </div>
        )

    }
    return (
        <div>
            <div>
                <div className="list-group">
                    <a href="#" className="list-group-item list-group-item-action bold text-center">
                        <strong className="primary">STUDENT DETAIL</strong></a>
                    <strong>   {displayData}</strong>
                </div>
            </div>
        </div>
    )

}