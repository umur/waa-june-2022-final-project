import PieChart from '../chart/PieChart';
import React, { useEffect, useState } from "react";
import BarChart from '../chart/BarChart';
import TopJobAdd from '../chart/TopJobAdd';
import AutoCompleteSelect from '../../common/AutoCompleteSelect';


export default function HomePage() {
    const [dataUrlByState, setDataUrlByState] = useState('/reports/studentByCity/""');

    const setValue = (name, value) => {
        let title = 'undefined';
        if (value[0] != null) {
            title = value[0].title;
        }
        switch (name) {
            case 'state':
                setDataUrlByState('/reports/studentByCity/' + title);
                break;
        }
    }

    return (
        <>
            <div className='border'>
                <div className='row'>
                    <div className="col-6">
                        <BarChart dataUrl={'/reports/jobByState'}></BarChart>
                    </div>
                    <div className="col-6">
                        <PieChart dataUrl={'/reports/studentByState'}></PieChart>
                    </div>
                    <div className="col-6">
                        < AutoCompleteSelect
                            name="state"
                            onChange={value => setValue('state', value)}
                            isMultiSelect={false}
                            label={"State"}
                            placeholder={"Eg. iowa, california"}
                            dataUrl='/reports/state' ></AutoCompleteSelect >
                        <PieChart dataUrl={dataUrlByState}></PieChart>
                    </div>
                    <div className="col-6">
                        <TopJobAdd></TopJobAdd>
                    </div>
                </div>
            </div>
        </>

    )
}