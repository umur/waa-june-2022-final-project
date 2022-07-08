import React from "react";
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { toBePartiallyChecked } from "@testing-library/jest-dom/dist/matchers";
import { useState } from "react";
import { useParams } from "react-router";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";
import StudentDetail from "../student/StudentDetail";

import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';

export default function AddComment() {

    const { id } = useParams();
    const [commentState, setCommentState] = useState('');

    const postData = async () => {
        const data = {
            comment: commentState,
            studentId: id
        };
        let params = "/comments";
        console.log(data.comment);
        let result = await postRequest(params, data);
    }



    const onClicked = () => {

    }

    const setCommentValue = (e) => {
        const value = e.target.value;
        setCommentState(value);
    }
    return (


        <div>

            <StudentDetail />


            <Container component="main" maxWidth="sm" sx={{ mb: 4 }}>
                <Paper variant="outlined" sx={{ my: { xs: 3, md: 6 }, p: { xs: 2, md: 3 } }}>
                    <Typography component="h1" variant="h6" align="center">
                        Add Comment
                    </Typography>

                    <TextField id="outlined-basic" label="Comment" variant="outlined" onChange={setCommentValue} />

                    <br></br>
                    <Button onClick={() => { postData() }} variant="contained" sx={{ mt: 3 }}>save</Button>

                </Paper>
            </Container>


        </div>

    )
}