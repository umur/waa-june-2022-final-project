import { Button, Input } from "@mui/material";
import axios from "axios";
import React, { useState } from "react";
import { postFileRequest } from "../setup/fetch-manager/FetchGateway";

export default function FileUpload(props) {
    const [selectedFile, setSelectedFile] = useState();

    const fileSelectedHandler = (e) => {
        let file = e.target.files[0];
        postFileRequest(file);

    }

    const postFileRequest = async (data) => {
        const api_url = 'http://localhost:8085/files/uploadFile';
        const fullURL = api_url;

        let formData = new FormData();
        formData.append('file', data);
        formData.append('type', props.folderName);
        formData.append('id', props.id)

        try {
            const response = await axios.post(fullURL, formData, {
                headers: {
                    'content-type': 'multipart/form-data'
                }
            });
            return response.data;
        } catch (error) {
            console.error(error);
        }

    }

    return (
        <>
            <div>
                <label htmlFor="contained-button-file">
                    <Input accept="*" id="contained-button-file" multiple type="file" onChange={fileSelectedHandler} />
                    {/* <Button variant="contained" component="span" onClick={fileSelectedHandler}>
                        Save
                    </Button> */}
                </label>
            </div>
        </>
    )
}