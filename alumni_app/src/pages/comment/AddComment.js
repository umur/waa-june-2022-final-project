import React from "react";
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { toBePartiallyChecked } from "@testing-library/jest-dom/dist/matchers";
import { useState } from "react";
import { useNavigate, useParams } from "react-router";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";
import StudentDetail from "../student/StudentDetail";

import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import { TextareaAutosize } from "@material-ui/core";

export default function AddComment() {

    const { id } = useParams();
    const [commentState, setCommentState] = useState('');
    const navigate = useNavigate();

    const postData = async () => {
        const data = {
            comment: commentState,
            studentId: id
        };
        let params = "/comments";
        console.log(data.comment);
        await postRequest(params, data);
        navigate('/Comments/' + id);
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


            <Container component="main" width='50%' sx={{ mb: 4 }}>
                <Paper variant="outlined" sx={{ my: { xs: 3, md: 6 }, p: { xs: 2, md: 3 } }}>
                    <Typography component="h1" variant="h6" align="center">
                        Add Comment
                    </Typography>

                    {/* <TextField id="outlined-basic" label="Comment" variant="outlined" onChange={setCommentValue} /> */}

                    <TextareaAutosize
                        onChange={setCommentValue}
                        aria-label="Comment"
                        minRows={8}
                        placeholder=""
                        style={{ width: '100%' }}
                    />


                    <br></br>
                    <Button onClick={() => { postData() }} variant="contained" sx={{ mt: 3 }}>save</Button>

                </Paper>
            </Container>


        </div>

    )
}