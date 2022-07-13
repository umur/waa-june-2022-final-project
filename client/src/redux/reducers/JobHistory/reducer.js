import {
  ADD_JOB_HISTORY,
  GET_JOB_HISTORY,
  JOB_HISTORY_LIST,
} from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const jobAdvertisementReducer = (state = { jobHistory: [] }, action) => {
  switch (action.type) {
    case JOB_HISTORY_LIST + SUCCESS_SUFFIX:
      return {
        ...state,
        jobHistory: [...action.payload.data],
      };

    case ADD_JOB_HISTORY + SUCCESS_SUFFIX:
      return {
        ...state,
        jobHistory: [...state.jobHistory, action.payload.data],
      };

    case GET_JOB_HISTORY + SUCCESS_SUFFIX:
      return action.payload.data;
    // case DELETE_JOB_ADVERTISEMENT:
    //   return state.filter((job) => job.id !== action.payload.job.id);
    
    default:
      return state;
  }
};

export default jobAdvertisementReducer;
