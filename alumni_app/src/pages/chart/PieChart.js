import React, { useEffect, useState } from "react"
import ReactECharts from 'echarts-for-react';
import { getRequest } from "../../setup/fetch-manager/FetchGateway";


function PieChart() {
    let [listData, setListData] = useState();

    const fetchData = async () => {
        let response = await getRequest('/reports/studentByState');
        setListData(response);
    }
    useEffect(() => {
        fetchData();
    }, [])
    let countVal = 0;
    let result = []
    if (listData != undefined) {
        result.push(
            <ReactECharts key={countVal++}
                option={{
                    title: {
                        text: '',
                        subtext: 'TOTAL NUMBER OF STUDENTS PER STATES',
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
                            name: 'Student Per State',
                            type: 'pie',
                            radius: '50%',
                            data: listData,
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
        )
    }

    return (
        <>
            <div className="text-center">
                <strong > STUDENT DATA</strong>
            </div>
            {result}
        </>

    );
}
export default PieChart;