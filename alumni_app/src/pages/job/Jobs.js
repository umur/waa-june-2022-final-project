import React, { useState } from "react";
import Button from '@material-ui/core/Button';
import { useNavigate } from "react-router";
import TableMain from "../../common/TableMain";
import AutoCompleteSelect from "../../common/AutoCompleteSelect";
import { Box } from "@mui/material";


const listParams = {
    'showDetail': true,
    'showEdit': false,
    'showDelete': true,
    'showAddComment': false,
    'dataUrl': '/jobs',
    'addCommentUrl': '//',
    'editUrl': '',
    'deleteUrl': '/',
    'detailUrl': '/'
}

export default function Jobs() {
    const navigate = useNavigate();
    const [state, setState] = useState();
    const [city, setCity] = useState();
    const [tag, setTag] = useState();
    const [name, setName] = useState();

    const setValue = (name, value) => {
        switch (name) {
            case 'state':
                setState(value[0].title);
                break;
            case 'city':
                setCity(value[0].title);
                break;
            case 'tag':
                setTag(value[0].title);
                break;
            case 'name':
                setName(value[0].title);
                break;
        }
    }

    return (
        <>
            <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
                <Button variant="contained" color="primary" onClick={() => (navigate('/Jobs/newJob'))}>
                    Add Job
                </Button>
            </div>

            <span className="list-header">  Job List </span>

            <div className="row body-custom">
                <Box sx={{ display: 'grid', gridTemplateColumns: 'repeat(5, 1fr)' }}>
                    <div>
                        < AutoCompleteSelect
                            name="state"
                            onChange={value => setValue('state', value)}
                            isMultiSelect={false}
                            label={"State"}
                            placeholder={"Eg. iowa, california"}
                            dataUrl='/reports/state' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="city"
                            onChange={value => setValue('city', value)}
                            isMultiSelect={false}
                            label={"City"}
                            placeholder={"Eg. fairfield, ottumwa"}
                            dataUrl='/reports/city' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="tag"
                            onChange={value => setValue('tag', value)}
                            isMultiSelect={false}
                            label={"Tag"}
                            placeholder={"Eg. mpp, fpp"}
                            dataUrl='/tags' ></AutoCompleteSelect >
                    </div>
                    <div>
                        < AutoCompleteSelect
                            name="name"
                            onChange={value => setValue('name', value)}
                            isMultiSelect={false}
                            label={"Company Name"}
                            placeholder={"Eg. messi, ronaldo, pele"}
                            dataUrl='/reports/studentName' ></AutoCompleteSelect >
                    </div>
                    <div>
                        <Button variant="contained" color="success" >Search</Button>
                    </div>
                </Box>
            </div>
            <div className="list-table">
                <TableMain listParams={listParams}></TableMain>
            </div>
        </>
    )
}