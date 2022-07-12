import { combineReducers } from "redux";

import jobAdvertisement from "./JobAdvertisement/reducer";
import userProfile from "./UserProfile/reducer";
import jobHistory from "./JobHistory/reducer";
import studentDetails from "./Student/reducer";

export default combineReducers({
  jobAdvertisement,
  userProfile,
  jobHistory,
  studentDetails
});
