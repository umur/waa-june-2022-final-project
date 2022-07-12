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
import PageNotFound from "./404";

import StudentProfile from "./student/Profile";
import UserService from "../services/UserService";
import FacultyProfile from "./faculty/Profile";
import EditAdvertisement from "../components/job/EditAdvertisement";

export default function Router() {
  return (
    <div>
      <Routes>
        {/* Admin Routes */}
        {UserService.hasRole(["admin"]) && {}}

        {/* Student Routes */}
        {UserService.hasRole(["student"]) && (
          <>
            <Route path="/" element={<Dashboard />} />

            <Route path="/student/profile" element={<StudentProfile />} />
            <Route path="/student/dashboard" element={<Dashboard />} />

            <Route
              path="student/job-advertisement/add"
              element={<Advertisement />}
            />
            <Route
              path="student/job-advertisement/edit"
              element={<EditAdvertisement />}
            />
            <Route path="/student/profile/update" element={<Registration />} />
            <Route
              path="/student/job-advertisement"
              element={<JobListings />}
            />

            <Route
              path="/student/job-history/add"
              element={<AddJobHistory />}
            />
          </>
        )}

        {/* Faculty Routes */}

        {UserService.hasRole(["faculty"]) && (
          <>
            <Route path="/" element={<UserProfile />} />

            <Route path="/faculty/profile" element={<FacultyProfile />} />

            <Route path="/faculty/dashboard" element={<Dashboard />} />

            <Route path="/faculty/student-list" element={<SearchStudent />} />

            <Route
              path="/faculty/profile/update"
              element={<FacultyRegistration />}
            />

            <Route
              path="/faculty/job-advertisement"
              element={<JobListings />}
            />
          </>
        )}

        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </div>
  );
}
