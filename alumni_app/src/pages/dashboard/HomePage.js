import PieChart from '../chart/PieChart';
import React, { useEffect, useState } from "react";
import BarChart from '../chart/BarChart';
import TopJobAdd from '../chart/TopJobAdd';


export default function HomePage() {
    return (
        <>
            <div className='row'>
                <div className="col-6">
                    <BarChart></BarChart>
                </div>
                <div className="col-6">
                    <PieChart></PieChart>
                </div>
            </div>
            <div>
                    <TopJobAdd></TopJobAdd>
            </div>
        </>

    )
}