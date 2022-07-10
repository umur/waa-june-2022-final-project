import { GET_USER_PROFILE } from "./actionsTypes";

export const getUserProfile = () => ({
  type: GET_USER_PROFILE,
  payload: {
    request: {
      url: "/students/profile",
    },
  },
});
