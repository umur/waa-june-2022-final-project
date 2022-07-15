import axios from "axios";

const MAIN_URL = "http://localhost:8081/api/v1/";

const user = JSON.parse(localStorage.getItem('user'));
axios.defaults.baseURL = 'http://localhost:8081/api/v1/';
if (user && user.access_token) {
    axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
}

class ApiService {
    getAllData(uri) {
        if (user && user.access_token) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
        }
        return axios.get(MAIN_URL + uri);
    }

    postData(uri, data) {
        if (user && user.access_token) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
        }
        return axios.post(MAIN_URL + uri, data);
    }

    getById(uri, id) {
        if (user && user.access_token) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
        }
        return axios.get(MAIN_URL + uri + '/' + id);
    }

    updateData(uri, data, id) {
        if (user && user.access_token) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
        }
        return axios.put(MAIN_URL + uri + '/' + id, data);
    }

    deleteData(uri, id) {
        if (user && user.access_token) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${user.access_token}`;
        }
        return axios.delete(MAIN_URL + uri + '/' + id);
    }

    // API Absulate Url
    JOB_LIST = "common/get-job";
    JOB_POST = "student/post-job";
    TAG_LIST = "common/getAllTag";
    SEARCH_JOB = "common/search-job";
    STUDENT_LIST = "faculty/all-student";
    SEARCH_STUDENT = "faculty/search-student";

    REGISTRATION = "registration/create-user";

    GET_ALLUSER = "admin/get-user";
    APPLY_JOB = "student/apply-job";

    GET_PROFILE = "common/get-profile";
    UPDATE_PROFILE = "common/update-profile";


    STAT_DATA = "faculty/stat";
    ACTIVE_INACTIVE_USER = "admin/active-user";
}

export default new ApiService();