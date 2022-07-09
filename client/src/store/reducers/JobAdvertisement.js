import { SUCCESS_SUFFIX } from "redux-axios-middleware";
import HttpService from "../../services/HttpService";
import UserService from "../../services/UserService";

const LIST_JOB_ADVERTISEMENT = "LIST_JOB_ADVERTISEMENT";
const ADD_JOB_ADVERTISEMENT = "ADD_JOB_ADVERTISEMENT";
const DELETE_JOB_ADVERTISEMENT = "DELETE_JOB_ADVERTISEMENT";

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

export const allJobAdvertisement = () => ({
  type: LIST_JOB_ADVERTISEMENT,
  payload: {
    request: {
      url: "http://localhost:8080/v1/api/comments",
    },
  },
});

export const addJobAdvertisement = (job) => {
  console.log(
    `${UserService.getUsername()} added job advertisement ${job.title}`
  );

  return {
    type: ADD_JOB_ADVERTISEMENT,
    payload: {
      request: {
        url: "/job-advertisement",
        method: HttpService.HttpMethods.POST,
        data: job,
      },
    },
  };
};

export const deleteJobAdvertisement = (job) => {
  console.log(`${UserService.getUsername()} deletes the job ${job.title}`);
  return {
    type: DELETE_JOB_ADVERTISEMENT,
    payload: {
      job,
      request: {
        url: `/job-advertisement/${job.id}`,
        method: HttpService.HttpMethods.DELETE,
      },
    },
  };
};
