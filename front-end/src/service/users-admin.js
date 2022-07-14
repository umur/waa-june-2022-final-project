import { BASE_API_URL } from '../common/Constants'
import axios from 'axios'
import { authHeader } from './base'

const BASE_URL = BASE_API_URL + '/api/v1'

class UserService {
    findAll() {
        return axios.get(BASE_URL + '/users', { headers: authHeader() });
    }

    changePass(id, request) {
        return axios.put(BASE_URL + '/users/' + id, request, { headers: authHeader() })
    }

    deactivate(id) {
        return axios.put(BASE_URL + '/users/deactivate/' + id, id, { headers: authHeader() })
    }

    activate(id) {
        return axios.put(BASE_URL + '/users/activate/' + id, id, { headers: authHeader() })
    }
}

export default new UserService()