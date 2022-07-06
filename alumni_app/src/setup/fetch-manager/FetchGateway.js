import axios from "axios";

const api_url = 'http://localhost:8080';

export async function getRequest(path) {
    const fullURL = api_url + path;
    try {
        const response = await axios.get(fullURL);
        return response.data;
    } catch (error) {
        console.error(error);
    }

}