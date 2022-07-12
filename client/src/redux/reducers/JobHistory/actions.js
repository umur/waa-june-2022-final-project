import {
  ADD_JOB_HISTORY,
  EDIT_JOB_HISTORY,
  GET_JOB_HISTORY,
  JOB_HISTORY_LIST,
} from "./actionsTypes";
import HttpService from "../../../services/HttpService";

export const getJobHistoryList = (data) => ({
  type: JOB_HISTORY_LIST,
  payload: {
    request: {
      url: "/job-history",
    },
  },
});

export const addJobHistory = (data) => ({
  type: ADD_JOB_HISTORY,
  payload: {
    request: {
      url: "/job-history",
      method: HttpService.HttpMethods.POST,
      data: data,
    },
  },
});

export const getJobHistoryById = (id) => ({
  type: GET_JOB_HISTORY,
  payload: {
    request: {
      url: "students/" + 10001 + "/job-history",
      method: HttpService.HttpMethods.GET,
    },
  },
});

export const editJobHistory = (data) => ({
  type: EDIT_JOB_HISTORY,
  payload: {
    request: {
      url: `/job-history/${data.id}`,
      method: HttpService.HttpMethods.PUT,
      data: data,
    },
  },
});
