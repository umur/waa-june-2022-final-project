import PieChart from '../chart/PieChart';
import React, { useEffect, useState } from "react";
import BarChart from '../chart/BarChart';


export default function HomePage() {
    return (
        <>
            <div>
                <div className="col-6">
                    <BarChart></BarChart>
                </div>
                <div className="col-6">
                    <PieChart></PieChart>
                </div>
            </div>
        </>

    )
}