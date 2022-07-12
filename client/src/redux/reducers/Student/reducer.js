import { GET_STUDENT_LIST } from "./actionsTypes";
import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const studentDetails = (state = {studentList: []}, action) => {
    switch(action.type) {
        case GET_STUDENT_LIST + SUCCESS_SUFFIX :
            return {
                ...state,
                studentList: [...action.payload.data],
                
            };
        
        default: return state;
    }
}

export default studentDetails;