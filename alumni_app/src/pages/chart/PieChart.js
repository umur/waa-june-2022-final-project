import React from "react"
import ReactECharts from 'echarts-for-react';

function PieChart() {
    return (
        <>        
       
            <ReactECharts
                option={{
                    title: {
                        text: 'Student Data',
                        subtext: 'total number of students per states',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left'
                    },
                    series: [
                        {
                            name: 'Access From',
                            type: 'pie',
                            radius: '50%',
                            data: [
                                { value: 1048, name: 'CALIFORNIA' },
                                { value: 735, name: 'IOWA' },
                                { value: 580, name: 'FLORIDA' },
                                { value: 484, name: 'KANSAS' },
                                { value: 300, name: 'COLORADO' }
                            ],
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                }}
            />
        </>

    );
}
export default PieChart;