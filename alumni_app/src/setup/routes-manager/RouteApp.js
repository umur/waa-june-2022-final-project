import React from "react";
import { Route, Routes } from "react-router";
import HomePage from "../../pages/dashboard/HomePage";
import FacultyList from "../../pages/faculty/FacultyList";
import StudentList from "../../pages/student/StudentList";
import Jobs from "../../pages/job/Jobs";
import AddComment from "../../pages/comment/AddComment";


export default function RouteApp() {
    return (
        <>
            <Routes>
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/Students' element={<StudentList />}></Route>
                <Route path='/Faculties' element={<FacultyList />}></Route>
                <Route path='/AddComment' element={<AddComment />}></Route>
                <Route path='/Jobs' element={<Jobs />}></Route>
            </Routes>
        </>
    )
}