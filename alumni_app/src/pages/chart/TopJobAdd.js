import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { getRequest } from "../../setup/fetch-manager/FetchGateway";

export default function TopJobAdd() {
    let [listData, setListData] = useState([]);

    const fetchData = async () => {
        let response = await getRequest('/jobs/getLastTop10');
        setListData(response);
    }
    useEffect(() => {
        fetchData();
    }, [])
    let countVal = 0;
    return (
        <>
            <div className="list-group">
                <a href="#" className="list-group-item list-group-item-action bold text-center">
                    <strong>LAST TOP 10 JOB ADVERTISEMENTS </strong></a>
                {
                    listData.map((x) => {
                        let colorText = 'pointer list-group-item list-group-item-action ';
                        switch (countVal) {
                            case 0:
                                colorText += "list-group-item-primary";
                                break;
                            case 1:
                                colorText += "list-group-item-success";
                                break;
                            case 2:
                                colorText += "list-group-item-danger";
                                break;
                            case 3:
                                colorText += "list-group-item-warning";
                                break;
                            case 4:
                                colorText += "list-group-item-primary";
                                break;
                            case 5:
                                colorText += "list-group-item-info";
                                break;
                            case 6:
                                colorText += "list-group-item-warning";
                                break;
                            case 7:
                                colorText += "list-group-item-dark";
                                break;
                            case 8:
                                colorText += "list-group-item-warning";
                                break;
                            case 9:
                                colorText += "list-group-item-success";
                                break;

                        }
                        if (countVal == 0) {

                        }
                        const url = '/JobDetails/' + x.id;
                        return <Link to={url} key={countVal++} className={colorText}>
                            <strong>{x.jobTitle}</strong> : {x.jobDesc}
                        </Link>
                    })
                }
            </div>
        </>
    )
}