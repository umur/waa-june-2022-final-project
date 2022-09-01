import HttpService from "../../../services/HttpService";
import { GET_STUDENT_LIST } from "./actionsTypes";

export const getStudentList = () => ({
    type: GET_STUDENT_LIST,
    payload: {
        request: {
            url: "/students",
        }
    }
});
