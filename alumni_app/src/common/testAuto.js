import React, { useState } from "react";
import AutoCompleteSelect from "./AutoCompleteSelect";

export default function TestAuto() {
    const [selectValue, setSelectValue] = useState();

    const setValue = (value) => {
        let values = '';
        value.map((x)=>{
            values += x.title;
        })
        setSelectValue(values);
    }

    return (
        <>
            {selectValue}
            < AutoCompleteSelect onChange={value => setValue(value)} dataUrl='/tags' ></AutoCompleteSelect >
        </>
    )
}