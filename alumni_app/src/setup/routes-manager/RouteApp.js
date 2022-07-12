import React from "react";
import { Route, Routes } from "react-router";
import AddComment from "../../pages/comment/AddComment";
import ChangePassword from "../../pages/dashboard/change-password/ChangePassword";
import HomePage from "../../pages/dashboard/HomePage";
import ErrorPage from "../../pages/ErrorPage";
import FacultyList from "../../pages/faculty/FacultyList";
import StudentList from "../../pages/student/StudentList";
import Profile from "../../pages/profile/Profile";
import StudentDetail from "../../pages/student/StudentDetail";
import CreateJob from "../../pages/job/CreateJob";
import Jobs from "../../pages/job/Jobs";
import FileUpload from "../../common/FileUpload";
import CommentList from "../../pages/comment/CommentList";
import JobDetails from "../../pages/job/JobDetails";
import Cv from "../../pages/cv/Cv";
import SubmitJob from "../../pages/job/SubmitJob";
import EditJob from "../../pages/job/EditJob";
import GetJobList from "../../pages/job/GetJobList";
import ViewApplicant from "../../pages/job/ViewApplicant";
import Login from "../../pages/sign-in/Login";
import { Dashboard } from "@material-ui/icons";
import { isAuthorized } from "../auth/Auth";
import { AUTHCONTEXT } from "../../App";
import Register from "../../pages/register/Register";

export default function RouteApp() {
  return (
    <>
      <Routes>
        <Route path="/Login" element={<Login />}></Route>
        <Route path="/" element={<HomePage />}></Route>
        <Route path="/Students" element={<StudentList />}></Route>
        <Route path="/Faculties" element={<FacultyList />}></Route>
        <Route path="/AddComment/:id" element={<AddComment />}></Route>
        <Route path="/Jobs" element={<Jobs />}></Route>
        <Route path="/Comments/:id" element={<CommentList />}></Route>
        <Route path="/Jobs" element={<CreateJob />}></Route>
        <Route path="*" element={<ErrorPage />}></Route>
        <Route path="/StudentDetails/:id" element={<StudentDetail />}></Route>
        <Route path="/Profile" element={<Profile />}></Route>
        <Route path="/reset-password" element={<ChangePassword />}></Route>
        <Route path="/Jobs/newJob" element={<CreateJob />}></Route>
        <Route path="/Jobs/:id" element={<GetJobList />}></Route>
        <Route path="/FileUpload" element={<FileUpload />}></Route>
        <Route path="/JobDetails/:id" element={<JobDetails />}></Route>
        <Route path="/cv" element={<Cv />}></Route>
        <Route path="/Jobs/:studentID/:jobID" element={<EditJob />}></Route>
        <Route
          path="/Jobs/:studentID/Applicants/:jobID"
          element={<ViewApplicant />}
        ></Route>
        <Route
          path="/JobDetails/additional/:id"
          element={<SubmitJob />}
        ></Route>
          <Route path="/Register" element={<Register />}></Route>
      </Routes>
    </>
  );
}
