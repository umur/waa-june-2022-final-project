import { combineReducers } from "redux";

import jobAdvertisement from "./JobAdvertisement/reducer";
import userProfile from "./UserProfile/reducer";

export default combineReducers({
  jobAdvertisement,
  userProfile,
});
