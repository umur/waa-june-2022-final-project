import { ADD_JOB_HISTORY } from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const jobAdvertisementReducer = (state = { jobHistory: [] }, action) => {
  switch (action.type) {
    case ADD_JOB_HISTORY + SUCCESS_SUFFIX:
      console.log(state);
      return {
        ...state,
        jobHistory: [...state.jobHistory, action.payload.data],
      };

    // case DELETE_JOB_ADVERTISEMENT:
    //   return state.filter((job) => job.id !== action.payload.job.id);

    default:
      return state;
  }
};

export default jobAdvertisementReducer;
