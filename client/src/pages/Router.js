import React, { useState } from "react";

import { Routes, Route } from "react-router-dom";
import { FacultyRegistration } from "../pages/faculty/Registration";
import UserProfile from "../components/profiles/UserProfile";
import Advertisement from "../components/job/Advertisement";
import Dashboard from "../components/dashboard/Dashboard";
import SearchStudent from "./faculty/SearchStudent";
import Registration from "./student/Registration";
import JobListings from "../components/job/Listings";
import AddJobHistory from "./student/AddJobHistory";

export default function Router() {
  return (
    <div>
      <Routes>
        <Route path="/student/profile" element={<UserProfile />}></Route>
        <Route path="/faculty/profile" element={<UserProfile />}></Route>

        <Route
          path="student/job-advertisement/add"
          element={<Advertisement />}
        />
        <Route path="/student/dashboard" element={<Dashboard />} />
        <Route path="/faculty/dashboard" element={<Dashboard />} />

        <Route path="/faculty/student-list" element={<SearchStudent />} />

        <Route path="/student/profile/update" element={<Registration />} />
        <Route
          path="/faculty/profile/update"
          element={<FacultyRegistration />}
        />

        <Route path="/student/job-advertisement" element={<JobListings />} />
        <Route path="/faculty/job-advertisement" element={<JobListings />} />

        <Route path="/student/job-history/add" element={<AddJobHistory />}>
          Job Listings
        </Route>
      </Routes>
    </div>
  );
}
