import React, { useEffect, useState } from "react"
import ReactECharts from 'echarts-for-react';
import { getRequest } from "../../setup/fetch-manager/FetchGateway";

function BarChart(props) {
    let [header, setHeader] = useState();
    let [data, setData] = useState();

    const fetchData = async () => {
        let headerData = [];
        let contentData = [];
        let response = await getRequest(props.dataUrl);
        response.map((x) => {
            headerData.push(x.name);
            contentData.push(x.value);
        })
        setHeader(headerData);
        setData(contentData);
    }
    useEffect(() => {
        fetchData();
    }, [])
    let count = 0;
    let dataList = [];
    if (header != undefined) {
        dataList.push(
            <>
                <ReactECharts key={count++}
                    option={{
                        xAxis: {
                            type: 'category',
                            data: header
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [
                            {
                                data: data,
                                type: 'bar'
                            }
                        ]
                    }}
                />
            </>

        )
    }

    return (
        <>
            <div className="text-center">
                <strong > JOB ADVERTISEMENTS PER LOCATION</strong>
            </div>
            {dataList}
        </>
    );
}
export default BarChart;