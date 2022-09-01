import { GET_STUDENT_LIST } from "./actionsTypes";

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
