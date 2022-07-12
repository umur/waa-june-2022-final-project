import axios from "axios";
import { useContext } from "react";
import Cookies from 'js-cookie';

const api_url = 'http://localhost:8085';

export async function getRequest(path) {
    const auth = 'Bearer ' + Cookies.get('token');
    const fullURL = api_url + path;
    try {
        const config = {
            headers: {
                Authorization: auth
            },
        };

        const response = await axios.get(fullURL, config);
        return response.data;
    } catch (error) {
        let as = error;
        // if (error.code == "ERR_NETWORK") {Cookies.remove('token') }
        console.error(error);
    }

}

export async function postRequest(path, data) {
    const fullURL = api_url + path;
    const auth = 'Bearer ' + Cookies.get('token');
    try {
        const response = await axios.post(fullURL, data, {
            headers: {
                'Authorization': auth
            }
        });
        return response.data;
    } catch (error) {
        console.error(error);
    }
}
export async function postRequestNoAuth(path, data) {
    const fullURL = api_url + path;
    try {
        const response = await axios.post(fullURL, data);
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
    const auth = 'Bearer ' + Cookies.get('token');
    try {
        const config = {
            headers: {
                Authorization: auth
            },
        };

        const response = await axios.delete(fullURL, config);
        return response.data;
    } catch (error) {
        console.error(error);
    }

}

export async function putRequest(path, data) {
    const fullURL = api_url + path;
    const auth = 'Bearer ' + Cookies.get('token');
    const config = {
        headers: {
            Authorization: auth
        },
    };
    axios.put(fullURL, data, config)
        .then(response => response)
        .catch(error => {

            console.error('There was an error!', error);
        });


}