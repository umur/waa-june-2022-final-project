import React from "react";
import { Route, Routes } from "react-router";
import AddComment from "../../pages/comment/AddComment";
import ChangePassword from "../../pages/dashboard/change-password/ChangePassword";
import HomePage from "../../pages/dashboard/HomePage";
import ErrorPage from "../../pages/ErrorPage";
import FacultyList from "../../pages/faculty/FacultyList";
import Jobs from "../../pages/job/Jobs";
import Profile from "../../pages/profile/Profile";
import StudentDetail from "../../pages/student/StudentDetail";
import StudentList from "../../pages/student/StudentList";


export default function RouteApp() {
    return (
        <>
            <Routes>
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/Students' element={<StudentList />}></Route>
                <Route path='/Faculties' element={<FacultyList />}></Route>
                <Route path='/AddComment/:id' element={<AddComment />}></Route>
                <Route path='/Jobs' element={<Jobs/>}></Route>
                <Route path='*' element={<ErrorPage />}></Route>
                <Route path='/StudentDetails/:id' element={<StudentDetail />}></Route>
                <Route path="/Profile" element={<Profile />}></Route>
                <Route path="/reset-password" element={<ChangePassword />}></Route>
            </Routes>
        </>
    )
}