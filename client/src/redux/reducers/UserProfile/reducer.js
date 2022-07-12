import { GET_FACULTY_PROFILE, GET_STUDENT_PROFILE, GET_USER_PROFILE } from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const userProfileReducer = (state = [], action) => {
  switch (action.type) {
    case GET_STUDENT_PROFILE + SUCCESS_SUFFIX:
      return action.payload.data;

    case GET_FACULTY_PROFILE + SUCCESS_SUFFIX:
      return action.payload.data;    

    default:
      return state;
  }
};

export default userProfileReducer;
