import React, { useContext, useEffect, useState } from "react";
import { useNavigate } from "react-router";
import { UserContext } from "../../context/context";
import { EditProfile } from "./EditProfile";
import JobCard from "../cards/JobCard";
import { JobContext } from "../../App";


const Student = (props) => {
  const jobs= useContext(JobContext)
  // const [user, setUser]= useState(useContext(UserContext).user)
  const user = useContext(UserContext);
  const [filterBy, setFilterBy]= useState('state')
  const [filteredItems, setFilteredItems]= useState([])
  const [item, setItem]= useState('')
  //console.log(user);
useEffect(()=>{
  const res = jobs.filter(job=>job[filterBy]===item)
 console.log(res)
 setFilteredItems(res)
},[filterBy,item])

  const navigate = useNavigate();
  const onClicked = (state) => {
    navigate("/students" + state);
  };
  
const handleSelectItem =()=>{
  console.log(filteredItems)
}
const onChangeSelect=(e)=>{
  const value = e.target.value;
  setFilterBy(value)
    }
  const [editClicked, setEditClicked] = useState(false);

  return (
    <div>
      {user ? (
        <div>
          <div className="user">
            {/* <i className="glyphicon glyphicon-user"></i> */}
            {/* <h3> Lets go for a <FaBeer />? </h3> */}
            <img
              className="card-img-top"
              style={{ width: "2rem", height: "2rem" }}
              src="https://th.bing.com/th/id/OIP.NkVlMldT0rn1beTIQuXU_wAAAA?w=158&h=180&c=7&r=0&o=5&pid=1.7"
              alt={user}
            />

            <h6>Hello, {user.state.fname}</h6>
            {/* <FontAwesomeIcon icon="fa-duotone fa-alicorn" /> */}
            {/* + ' '+ user.state.lname */}
          </div>
          <div className="container specialBorder">
            {/* <div  style={{"width": "20rem", "height":"10rem"}}> */}
            {/* <img className="card-img-top" src="https://3.bp.blogspot.com/-7gU8ppxhxgU/V9Rt2_3TxvI/AAAAAAAAhss/upIGvFPk8QYnIrYowMhARrSt5UHKDQWLQCLcB/s1600/student_profile_icon.gif" alt={user}/>  */}
            <img
              className="card-img-top "
              style={{ width: "12rem", height: "10rem" }}
              src="https://th.bing.com/th/id/OIP.NkVlMldT0rn1beTIQuXU_wAAAA?w=158&h=180&c=7&r=0&o=5&pid=1.7"
            />
            <div className="card-body container-fluid">
              <div>
              <h1 style={{"text-align": "center"}}>Student</h1>
                {/* <h5 className="card-title">{user.state.fname}</h5> */}
                <p className="card-text ">
                  <p>First Name: {user.state.fname}</p>
                  <p>Last Name: {user.state.lname}</p>

                  <p>Major: {user.state.major}</p>

                  <p>
                    Address:{" "}
                    {user.state.street +
                      " " +
                      user.state.city +
                      " " +
                      user.state.state +
                      " " +
                      user.state.zipCode}
                  </p>
                </p>
                {/* <a href="#" className="btn btn-primary">Go somewhere</a> */}
              </div>
            </div>
          </div>
          <div className="container specialBorder ">
            <div className="inputToleft gapButton">
              <button
                type="button"
                className="btn btn-outline-secondary btn-lg"

                onClick={e=> setEditClicked(!editClicked)}
              >
                Edit Profle
              </button>
            </div>
            <div className="inputToleft gapButton">
              <button 
              type="button" 
              class="btn btn-outline-secondary btn-lg"
              onClick={()=> navigate('/jobs/upload')}
              >
                Upload Job
              </button>
            </div>
            <div className="inputToleft gapButton">
              {/* <button type="button" class="btn btn-outline-secondary btn-lg"
               onClick={handleSelectItem}
              >
                 Search Job Advertisemnts By
                 <i class="fas fa-search"></i>
              </button> */}
               <div>
                  <button type="button" className="btnsearch"
                  onClick={handleSelectItem}
                  >
                    Search Job Advertisemnts By
                    <i class="fas fa-search"></i>
                  </button>
                  <select
                    onChange={onChangeSelect}
                  >
                    <option value="state">State</option>
                    <option value="city">City</option>
                    <option value="companyName">Company Name</option>
                    <option value="tag">Tag</option>

                  </select>

                  <input type= 'text'
                  placeholder="search by"
                  value={item}
                  onChange={e=> {setItem(e.target.value)}}
                  />
                </div>
                <div className="row">
                  <tr>
              {filteredItems
                ? filteredItems.map(job=> {
                    return(
                      <div className="col" >

                      
                       <JobCard key= {job.id} props= {job}/>

                        </div>
                    )
                })
                : 
                (
                  jobs.map(job=> {
                    return(
                      <div className="col" >
                       <JobCard key= {job.id} props= {job}/>

                        </div>
                    )
                })
                )
                
                }

                </tr>
           </div> 
            </div>
        
          </div>
          {/* <div className="field ">
            <form className="row g-3 ">
              <div className="col-md-6 ">
                <label for="inputEmail4" class="form-label">
                  Email
                </label>
                <input
                  type="email"
                  class="form-control"
                  id="inputEmail4"
                ></input>
              </div>
              <div className="col-md-6">
                <label for="inputPassword4" class="form-label">
                  Password
                </label>
                <input
                  type="password"
                  class="form-control"
                  id="inputPassword4"
                ></input>
              </div>
              <div className="col-12">
                <label for="inputAddress" class="form-label">
                  Address
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="inputAddress"
                  placeholder="1234 Main St"
                ></input>
              </div>
              <div className="col-12">
                <label for="inputAddress2" class="form-label">
                  Address 2
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="inputAddress2"
                  placeholder="Apartment, studio, or floor"
                ></input>
              </div>
              <div clasNames="col-md-6">
                <label for="inputCity" className="form-label">
                  City
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="inputCity"
                ></input>
              </div>
              <div class="col-md-4">
                <label for="inputState" class="form-label">
                  State
                </label>
                <select id="inputState" class="form-select">
                  <option selected>Choose...</option>
                  <option>...</option>
                </select>
              </div>
              <div className="col-md-2">
                <label for="inputZip" class="form-label">
                  Zip
                </label>
                <input type="text" class="form-control" id="inputZip"></input>
              </div>
              <div class="col-12">
                <div class="form-check">
                  <input
                    class="form-check-input"
                    type="checkbox"
                    id="gridCheck"
                  ></input>
                  <label class="form-check-label" for="gridCheck">
                    Check me out
                  </label>
                </div>
              </div>
            </form>
          </div> */}
          {/* <h4>First Name: { user.state.fname}</h4>
          <h4>Last Name: { user.state.lname}</h4>

          <h4>Major: { user.state.major}</h4>

          <h4>Address: {user.state.street +' '+ user.state.city+' '+ user.state.state+' '+ user.state.zipCode}</h4> */}

          {/* <button className="btn btn-primary" onClick={()=> setEditClicked(!editClicked)}>Edit Profile</button> */}

          {/* <button className="btn btn-primary" onClick={()=> setEditClicked(!editClicked)}></button>
          <button className="btn btn-primary" onClick={()=> setEditClicked(!editClicked)}>Edit Profile</button>
          <button className="btn btn-primary" onClick={()=> setEditClicked(!editClicked)}>Edit Profile</button> */}

          {
          editClicked ? (
            <div>
              <EditProfile />
            </div>
          ) : (
            ""
          )}
        </div>
      ) : (
        <h1> No user Logged in </h1>
      )}
    </div>
  );
};

export default Student;
