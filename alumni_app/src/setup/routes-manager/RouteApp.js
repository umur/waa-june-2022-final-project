import React from "react";
import { Route, Routes } from "react-router";
import HomePage from "../../pages/dashboard/HomePage";
import FacultyList from "../../pages/faculty/FacultyList";
import Profile from "../../pages/profile/Profile";
import StudentList from "../../pages/student/StudentList";


export default function RouteApp() {
    return (
        <>
            <Routes>
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/Students' element={<StudentList />}></Route>
                <Route path='/Faculties' element={<FacultyList />}></Route>
                <Route path='/Jobs' element={<HomePage />}></Route>
                <Route path='/Profile' element={<Profile/>}></Route>
                
            </Routes>
        </>
    )
}