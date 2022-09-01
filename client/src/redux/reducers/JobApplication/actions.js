import { LIST_JOB_APPLICATION } from "./actionsTypes";

import HttpService from "../../../services/HttpService";

export const allJobApplication = () => ({
  type: LIST_JOB_APPLICATION,
  payload: {
    request: {
      url: "/job-applications",
    },
  },
});
