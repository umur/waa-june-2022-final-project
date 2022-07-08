import React from "react";
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { toBePartiallyChecked } from "@testing-library/jest-dom/dist/matchers";
import { useState } from "react";
import { useParams } from "react-router";
import { postRequest } from "../../setup/fetch-manager/FetchGateway";

export default function AddComment() {

    const { id } = useParams();
    const [commentState, setCommentState] = useState('');

    const postData = async () => {
        const data = {
            comment: commentState
        };
        let params = "/comments";
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
            {id}
            <Box
                component="form"
                sx={{
                    '& > :not(style)': { m: 5, height: '3ch', width: '50ch' },
                }}
                noValidate
                autoComplete="off"
            >
                <TextField id="outlined-basic" label="Comment" variant="outlined" onChange={setCommentValue} />

            </Box>
            <Box
                component="form"
                sx={{
                    '& > :not(style)': { ml: 5, height: '3ch', width: '10ch' },
                }}
                noValidate
                autoComplete="off"
            >

                <Button onClick={() => { postData() }} variant="contained">save</Button>
            </Box>


        </div>

    )
}