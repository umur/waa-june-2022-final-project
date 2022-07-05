import React from 'react'
import MyRoutes from '../MyRoutes'
import Header from './Header'
import JobFeed from '../dashboard/JobFeed'
export default function Main(){
    return(
        <div>
            <Header></Header>
            <JobFeed></JobFeed>
            <MyRoutes />
        </div>
    )
}