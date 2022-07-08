import React, { useState } from 'react'
import {Routes, Route} from 'react-router-dom'

import UserProfile from  '../components/profiles/UserProfile'
import Advertisement from '../components/job/Advertisement'
import Dashboard from '../components/dashboard/Dashboard'

import Registration from './student/Registration'

import JobListing from '../components/job/Listing'
import JobListings from '../components/job/Listings'

export default function Router(){
    const initialState = {
        listings: [{id: 1, title:"test", aboutUs: "about us", description:"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has "},
        {id: 2, title:"test2", aboutUs: "about us", description:"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has "},{id: 3, title:"test3", aboutUs: "about us", description:"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. "}]
    }
    let [jobListingState, setJobListingState] = useState(initialState);
    return(
        <div>
            <Routes>
                <Route path="/user-profile" element={<UserProfile />}>My Profile</Route>
                <Route path="/add-new-advertisement" element={<Advertisement />}>Add New Advertisement</Route>
                <Route path="/dashboard" element={<Dashboard />}>Dashboard</Route>
                <Route path="/student/registration" element={<Registration/>}> Registration</Route>
                <Route path='/job-listings' element={<JobListings listings={jobListingState.listings}/>}>Job Listings</Route>
            </Routes>
        </div>
    )
}