import { GET_STUDENT_PROFILE } from "./actionsTypes";
import { GET_FACULTY_PROFILE } from "./actionsTypes";

export const getUserProfile = () => ({
  type: GET_STUDENT_PROFILE,
  payload: {
    request: {
      url: "/students/profile",
    },
  },
});

export const getFacultyProfile = () => ({
  type: GET_FACULTY_PROFILE,
  payload: {
    request: {
      url: "/faculties/profile"
    }
  }
})
