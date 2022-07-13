import React,{useContext} from "react";

import { UserContext } from '../../context/context'


const SampleProfile =()=>{
    const user = useContext(UserContext)

    return(
        <>
        THIS 
<div className="card" style="width: 18rem;">
  <img className="card-img-top" src="..." alt={user}/>
  <div className="card-body">
    <h5 className="card-title">{user.lname}</h5>
    <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" className="btn btn-primary">Go somewhere</a>
  </div>
</div>

        </>
    )
}

export default SampleProfile;