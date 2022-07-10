import { combineReducers } from "redux";

import jobAdvertisementReducer from "./JobAdvertisement/reducer";
import userProfileReducer from "./UserProfile/reducer";

export default combineReducers({
  jobAdvertisementReducer,
  userProfileReducer,
});
