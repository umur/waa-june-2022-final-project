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
            <div><Typography variant="h5">
                <label>First Name: </label>
                <label>{studentState.firstName}</label>
                <br></br>
                <label>Last Name: </label>
                <label>{studentState.lastName}</label>
                <br></br>
                <label>Email: </label>
                <label>{studentState.email}</label>
                <br></br>
                <label>State: </label>
                <label>{studentState.address.state}</label>
                <br></br>
                <label>City: </label>
                <label>{studentState.address.city}</label>
            </Typography>;



                {/* <Typography variant="h6" color="inherit" noWrap>
                            <StepLabel >Name: </StepLabel>
                            <StepLabel>Hari Lal</StepLabel>
                        </Typography> */}

            </div>
        )

    }
    return (

        <div>
            <Container component="main" maxWidth="sm" sx={{ mb: 4 }}>
                <Paper variant="outlined" sx={{ my: { xs: 3, md: 6 }, p: { xs: 2, md: 3 } }}>
                    <Typography component="h1" variant="h4" align="center">
                        Student Detail
                    </Typography>
                    {displayData}
                </Paper>

            </Container>
        </div>
    )

}