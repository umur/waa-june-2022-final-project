import axios from "axios";

const api_url = 'http://localhost:8085';

export async function getRequest(path) {
    const fullURL = api_url + path;
    try {
        const response = await axios.get(fullURL);
        return response.data;
    } catch (error) {
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