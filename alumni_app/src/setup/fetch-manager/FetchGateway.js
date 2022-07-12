import axios from "axios";
import { useContext } from "react";
import Cookies from 'js-cookie';

const api_url = 'http://localhost:8085';

export async function getRequest(path) {
    const auth = 'Bearer '+ Cookies.get('token');
    const fullURL = api_url + path;
    try {
        const config = {
            headers: {
                Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhc2hpc2hAbWl1LmVkdSIsInJvbGVzIjoiQURNSU4iLCJpZCI6MSwidXNlck5hbWUiOiJhc2hpc2hAbWl1LmVkdSIsImV4cCI6MTY1NzYwMDI2NywiaWF0IjoxNjU3NTgyMjY3fQ.5IILwfiqnI02cOoV4M_sLlDMWq5udmaqXie1m597uMW4Fv5RhSzLBYzRUOmNcpc8YYa3pNKSz34BOsVA6GYBiA',
            },
          };

        const response = await axios.get(fullURL, config);
        return response.data;
    } catch (error) {
        let as =error;
        debugger
        console.error(error);
    }

}

export async function postRequest(path, data) {
    const fullURL = api_url + path;
    try {
        const response = await axios.post(fullURL, data, {
            headers: {
                // 'content-type': 'text/json'
            }
        });
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

export async function postFileRequest(path, data) {
    const fullURL = api_url + path;

    let formData = new FormData();
    formData.append('file', data);
    formData.append('type', 'student');
    formData.append('id', 1)

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

export async function deleteRequest(path) {
    const fullURL = api_url + path;
    try {
        const response = await axios.delete(fullURL);
        return response.data;
    } catch (error) {
        console.error(error);
    }

}

export async function putRequest(path, data) {
    const fullURL = api_url + path;
    try {
        const response = await axios.put(fullURL, data, {
            headers: {
                // 'content-type': 'text/json'
            }
        });
        return response.data;
    } catch (error) {
        console.error(error);
    }
}