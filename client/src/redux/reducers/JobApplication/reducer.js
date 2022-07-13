import { LIST_JOB_APPLICATION } from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const jobApplicationReducer = (state = { jobApplication: [] }, action) => {
  switch (action.type) {
    case LIST_JOB_APPLICATION + SUCCESS_SUFFIX:
      return {
        ...state,
        jobApplication: [...action.payload.data],
      };

    default:
      return state;
  }
};

export default jobApplicationReducer;
