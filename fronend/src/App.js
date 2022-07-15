import "./App.css";
import Header from "./components/header";
import Footer from "./components/footer";
import "bootstrap/dist/css/bootstrap.min.css";
import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Dashboard from "./components/dashboard";
import Registration from "./components/auth-component/register.component";
import Profile from "./components/auth-component/profile.component";
import Login from "./components/auth-component/login.component";

import JobPost from "./components/job-component/job-post";
import JobList from "./components/job-component/job-list";
import JobUpdate from "./components/job-component/job-update";

import StudentList from "./components/student-component/student-list.component";
import AllUserList from "./components/user-component/all-user-list.component";
function App() {
  const [token, setToken] = useState();
  let user = localStorage.getItem("user");
  if (!user) {
    // return <Login />
    return (
      <Router>
        <Routes>
          <Route path="registration" element={<Registration />} />
          <Route path="login" element={<Login />} />
        </Routes>
        <Footer />
      </Router>
    );
  }
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="dashboard" element={<Dashboard />} />
        <Route path="profile" element={<Profile />} />
        <Route path="job-post" element={<JobPost />} />
        <Route path="job-list" element={<JobList />} />
        <Route path="job-update" element={<JobUpdate />} />
        <Route path="student-list" element={<StudentList />} />
        <Route path="all-user-list" element={<AllUserList />} />
      </Routes>
      <Footer />
    </Router>
  );
}

export default App;
