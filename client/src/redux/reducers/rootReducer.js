import { combineReducers } from "redux";

import jobAdvertisement from "./JobAdvertisement/reducer";
import userProfile from "./UserProfile/reducer";
import jobHistory from "./JobHistory/reducer";
import studentList from "./Student/reducer";
import jobApplicationReducer from "./JobApplication/reducer";

export default combineReducers({
  jobAdvertisement,
  userProfile,
  jobHistory,
  students: studentList,
  jobApplication: jobApplicationReducer,
});
