import { GET_STUDENT_LIST } from "./actionsTypes";
<<<<<<< HEAD
import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const studentReducer = (state = {studentList: []}, action) => {
    switch(action.type) {
        case GET_STUDENT_LIST + SUCCESS_SUFFIX :
            return {
                ...state,
                studentList: [...action.payload.data],
                
            };
        
        default: return state;
    }
}

export default studentReducer;
=======

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const studentList = (state = { students: [] }, action) => {
  switch (action.type) {
    case GET_STUDENT_LIST + SUCCESS_SUFFIX:
      return {
        ...state,
        students: [...action.payload.data],
      };

    default:
      return state;
  }
};
export default studentList;
>>>>>>> 46fde9b66436a2211db11b433bfcb35aefaa3df0
