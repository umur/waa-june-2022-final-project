import { combineReducers } from "redux";

import jobAdvertisement from "./JobAdvertisement/reducer";
import userProfile from "./UserProfile/reducer";
import jobHistory from "./JobHistory/reducer";
import studentReducer from "./Student/reducer";

export default combineReducers({
  jobAdvertisement,
  userProfile,
  jobHistory,
  students: studentReducer
});
