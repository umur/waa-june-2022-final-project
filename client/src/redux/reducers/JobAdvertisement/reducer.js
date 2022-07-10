import {
  LIST_JOB_ADVERTISEMENT,
  ADD_JOB_ADVERTISEMENT,
  DELETE_JOB_ADVERTISEMENT,
} from "./actionsTypes";

import { SUCCESS_SUFFIX } from "redux-axios-middleware";

const jobAdvertisementReducer = (state = [], action) => {
  switch (action.type) {
    case LIST_JOB_ADVERTISEMENT + SUCCESS_SUFFIX:
      return action.payload.data;

    case DELETE_JOB_ADVERTISEMENT:
      return state.filter((job) => job.id !== action.payload.job.id);

    default:
      return state;
  }
};

export default jobAdvertisementReducer;
