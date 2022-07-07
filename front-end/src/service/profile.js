import { BASE_API_URL } from "../common/Constants";
import axios from "axios";
import { authHeader } from "./base";

const BASE_URL = BASE_API_URL + "/api/v1/profile";

class ProfileService {
    getMe() {
        return axios.get(BASE_URL, { headers: authHeader() });
    }
}

export default new ProfileService();