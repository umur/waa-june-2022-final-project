import PieChart from '../chart/PieChart';
import React, { useEffect, useState } from "react";
import BarChart from '../chart/BarChart';


export default function HomePage() {
    return (
        <>
            <div>
                <div className='row'>
                    <div className="col-6">
                        <BarChart></BarChart>
                    </div>
                    <div className="col-6">
                        <PieChart></PieChart>
                    </div>
                </div>
                <div>
                    <div className="list-group">
                        <a href="#" className="list-group-item list-group-item-action bold text-center">
                            <strong>Last Top 10 Job Advertisement </strong></a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-primary">This is a primary list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-secondary">This is a secondary list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-success">This is a success list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-danger">This is a danger list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-warning">This is a warning list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-info">This is a info list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-light">This is a light list group item</a>
                        <a href="#" className="list-group-item list-group-item-action list-group-item-dark">This is a dark list group item</a>
                    </div>
                </div>
            </div>
        </>

    )
}