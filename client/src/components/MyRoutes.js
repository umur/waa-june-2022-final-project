import React from 'react'
import {Routes, Route} from 'react-router-dom'
import UserProfile from './profiles/UserProfile'
export default function MyRoutes(){
    return(
        <div>
            <Routes>
                {/* <Route path="/main" element={<Main />}>Main</Route> */}
                <Route path="/user-profile" element={<UserProfile />}>My Profile</Route>
            </Routes>
        </div>
    )
}