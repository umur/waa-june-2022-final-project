import React from 'react'
import ReactEcharts from "echarts-for-react";

import TagsWithLocation from './TagsWithLocation'
import JobAdsLocation from './JobAdsLocation'
import StudentsPerState from './StudentPerState'
import StudentPerCity from './StudentPerCity';
import USAmap from './USAmap';

const ChartsPage = () => {
    return (
        <div className="container ">
            <div className='row mt-5'>
                <div className='col mt-20'>
                    <StudentsPerState></StudentsPerState>
                </div>
                <div className='col'>
                    <JobAdsLocation></JobAdsLocation>
                </div>
            </div>
            <div className='row mt-5'>
                <div className='col'>
                    <TagsWithLocation></TagsWithLocation>
                </div>
                <div className='col'>
                    <StudentPerCity></StudentPerCity>
                </div>
            </div>
            <div className='row'>
                <></>
            </div>

        </div>
    )
}

export { ChartsPage }