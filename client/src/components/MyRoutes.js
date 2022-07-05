import React from 'react'
import {Routes, Route} from 'react-router-dom'
import StudentProfile from './profiles/StudentProfile'
import Main from './dashboard/Main'
export default function MyRoutes(){
    return(
        <div>
            <Routes>
                {/* <Route path="/main" element={<Main />}>Main</Route> */}
                <Route path="/student-profile" element={<StudentProfile />}>My Profile</Route>
            </Routes>
        </div>
    )
}