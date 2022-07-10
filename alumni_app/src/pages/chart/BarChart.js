import React from "react"
import ReactECharts from 'echarts-for-react';

function BarChart() {
    return (
        <>
            <div className="text-center">
                <strong > JOB ADVERTISEMENTS PER LOCATION</strong>
            </div>
            <ReactECharts
                option={{
                    xAxis: {
                        type: 'category',
                        data: ['IOWA', 'WASHINGTON', 'ALASKA', 'CALIFORNIA', 'COLORADO', 'FLORIDA', 'KANSAS']
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [
                        {
                            data: [120, 200, 150, 80, 70, 110, 130],
                            type: 'bar'
                        }
                    ]
                }}
            />
        </>
    );
}
export default BarChart;