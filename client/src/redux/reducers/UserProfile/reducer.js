import { GET_USER_PROFILE } from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const userProfileReducer = (state = [], action) => {
  switch (action.type) {
    case GET_USER_PROFILE + SUCCESS_SUFFIX:
      return action.payload.data;

    default:
      return state;
  }
};

export default userProfileReducer;
