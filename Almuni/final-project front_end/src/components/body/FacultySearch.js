import React, { useEffect, useState } from "react";
import { UserContext } from "../../context/context";
import { useContext } from "react";
import { JobContext } from "../../App";
import JobCard from "../cards/JobCard";
import { useNavigate } from "react-router";
import { EditProfile } from "./EditProfile";

const FacultySearch = () => {
  const user = useContext(UserContext);

  const jobs= useContext(JobContext)

  const [filterBy, setFilterBy]= useState('state')

  const [filteredItems, setFilteredItems]= useState([])

  const [item, setItem]= useState('')
  const navigate = useNavigate();

  const onClicked = (state) => {
    navigate("/students" + state);
  };
  useEffect(()=>{
    const res= jobs.filter(job=> job[filterBy]===item)
    //console.log(res)
    setFilteredItems(res)


  }, [filterBy, item])

  const handleSelectItem=()=>{
    console.log(filteredItems)
  }
  const onChangeSelect =(e)=>{
    const value= e.target.value;
    setFilterBy(value)
  }
  const [editClicked, setEditClicked] = useState(false);
  return (
    <>
  
      <div>
        
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
              <h1 style={{ "text-align": "center" }}>Faculty</h1>
              <div className="card-body container-fluid">
                <div>
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
                <button type="button" class="btn btn-outline-secondary btn-lg"
                onClick={()=> navigate('/jobs/upload')}>
                  View Job
                </button>
              </div>
              {/* <div className="inputToleft gapButton">
                <button type="button" class="btn btn-outline-secondary btn-lg">
                  View Job
                </button>
              </div> */}
            </div>
            <div className="field ">
            
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
               
              {
          editClicked ? (
            <div>
              <EditProfile />
            </div>
          ) : (
            ""
          )}   
                
                
    
                
             
            
          </div>
      
      </div>
    </>
  );
};

export default FacultySearch;
