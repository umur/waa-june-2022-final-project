import React from "react";
import { Routes, Route } from "react-router-dom";
import UserProfile from "../components/profiles/UserProfile";
import Dashboard from "../components/dashboard/Dashboard";
import { Registration as FacultyRegistration } from "../pages/faculty/Registration";

export default function MyRoutes() {
  return (
    <div>
      <Routes>
        {/* <Route path="/main" element={<Main />}>Main</Route> */}
        <Route path="/user-profile" element={<UserProfile />}></Route>

        <Route path="/dashboard" element={<Dashboard />}>
          Dashboard
        </Route>
        <Route
          path="/faculty-registration"
          element={<FacultyRegistration />}
        ></Route>
      </Routes>
    </div>
  );
}
