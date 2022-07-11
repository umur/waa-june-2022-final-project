import PieChart from '../chart/PieChart';
import React, { useEffect, useState } from "react";
import BarChart from '../chart/BarChart';
import TopJobAdd from '../chart/TopJobAdd';
import AutoCompleteSelect from '../../common/AutoCompleteSelect';


export default function HomePage() {
    const [state, setState] = useState();
    const [dataUrl, setDataUrl] = useState('/reports/studentByCity/Iowa');

    const setValue = (name, value) => {
        let title = 'undefined';
        if (value[0] != null) {
            title = value[0].title;
        }
        switch (name) {
            case 'state':
                setState(title);
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
                        <PieChart></PieChart>
                    </div>
                    <div className="col-6">
                        < AutoCompleteSelect
                            name="state"
                            onChange={value => setValue('state', value)}
                            isMultiSelect={false}
                            label={"State"}
                            placeholder={"Eg. iowa, california"}
                            dataUrl='/reports/state' ></AutoCompleteSelect >
                        <PieChart></PieChart>
                    </div>
                    <div className="col-6">
                        <TopJobAdd></TopJobAdd>
                    </div>
                </div>
            </div>
        </>

    )
}