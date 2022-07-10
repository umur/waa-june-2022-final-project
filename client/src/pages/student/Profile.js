import { useDispatch, useSelector } from "react-redux";
import React, { useEffect } from "react";
import { getUserProfile } from "../../redux/reducers/UserProfile/actions";

function StudentProfile() {
  const dispatch = useDispatch();
  const userProfile = useSelector((state) => state.userProfile);

  useEffect(() => {
    dispatch(getUserProfile());
  }, []);
  return <div>{JSON.stringify(userProfile)}</div>;
}

export default StudentProfile;
