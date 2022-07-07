import { Container } from "@material-ui/core";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { getRequest } from '../../setup/fetch-manager/FetchGateway'


export default function HomePage() {

    // const fetchData = async () => {
    //     let result = await getRequest('/todos');
    //     console.log(result);
    // }

    // useEffect(() => {
    //     fetchData();
    // }, [])

    return (
        <>
                <div>
                    Home Page Is Here !
                </div>
        </>

    )
}