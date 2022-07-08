import { Autocomplete, Chip, TextField } from '@mui/material';
import React, { useEffect, useState } from 'react'
import { getRequest } from '../setup/fetch-manager/FetchGateway';


export default function AutoCompleteSelect(props) {
    const [value, setValue] = React.useState();
    const [arrayData, setArrayData] = React.useState();

    const fetchData = async () => {
        let response = await getRequest(props.dataUrl);
        setArrayData(response);
    }

    useEffect(() => {
        fetchData();
    }, [])

    return (
        <>
            {
                (arrayData != undefined ?
                    <>
                        <Autocomplete
                            multiple
                            id="fixed-tags-demo"
                            value={value}
                            onChange={(event, newValue) => {
                                setValue([
                                    ...newValue
                                ]);
                                props.onChange([
                                    ...newValue
                                ])
                            }
                            }
                            options={arrayData}
                            getOptionLabel={(option) => option.title}
                            style={{ width: 500 }}
                            renderInput={(params) => (
                                <TextField {...params} label="Job Tag" placeholder="Eg. C#, Java, JavaScript" />
                            )}
                        />
                    </>
                    : ''
                )
            }
        </>
    );
}
