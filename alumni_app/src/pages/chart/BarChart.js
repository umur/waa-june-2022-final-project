import React from "react"
import ReactECharts from 'echarts-for-react';

function BarChart() {
    return (
        <>

            <h3 className="text-center"> Job Advertisements Per Location</h3>
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