import { BASE_API_URL } from "../common/Constants";
import axios from 'axios'

const BASE_URL = BASE_API_URL + "/api/auth";

class AuthenticationService {
    login(user) {
        return axios.post(BASE_URL + '/signin', user);
    }

    register(user) {
        return axios.post(BASE_URL + '/signup', user);
    }

    verify(req) {
        return axios.post(BASE_URL + '/verify', req)
    }
}

export default new AuthenticationService();