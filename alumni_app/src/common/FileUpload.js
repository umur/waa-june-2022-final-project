import { Button, Input } from "@mui/material";
import axios from "axios";
import React, { useState } from "react";
import { postFileRequest } from "../setup/fetch-manager/FetchGateway";
import Cookies from 'js-cookie';

export default function FileUpload(props) {
    const [savedUrl, setSavedUrl] = useState();

    const fileSelectedHandler = (e) => {
        let file = e.target.files[0];
        postFileRequest(file);

    }

    const postFileRequest = async (data) => {
        const api_url = 'http://localhost:8085/files/uploadFile';
        const fullURL = api_url;
        const auth = 'Bearer ' + Cookies.get('token');
        let formData = new FormData();
        formData.append('file', data);
        formData.append('type', props.folderName);
        formData.append('id', props.id)

        try {
            const response = await axios.post(fullURL, formData, {
                headers: {
                    'Authorization': auth,
                    'content-type': 'multipart/form-data'
                }
            });
            setSavedUrl(response.data);
            return response.data;
        } catch (error) {
            console.error(error);
        }

    }

    return (
        <>
            <div>
                <label htmlFor="contained-button-file">
                    <Input accept="*" id="contained-button-file" multiple type="file" onClick={props.getUrl(savedUrl)} onChange={fileSelectedHandler} />
                    {/* <Button variant="contained" component="span" onClick={props.getUrl(savedUrl)}>
                        Save
                    </Button> */}
                </label>
            </div>
        </>
    )
}