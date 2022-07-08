import React from "react";
import Button from '@material-ui/core/Button';
import { Link } from "react-router-dom";
export default function Jobs() {
    return (
        <div style={{ display: 'flex', justifyContent: 'flex-end' }}>
         <Link to="/Jobs/newJob">
           <Button  variant="contained" color="primary">
               Add Job
           </Button>
          </Link>
        </div>

    )
}