import React, { useContext, useState } from 'react'
import axios from "axios";
import { UserContext } from '../../context/context';

const AddJob = () => {


    const store = useContext(UserContext);

    const user= store.state

    const initialState = {
        companyName: "",
        description: "",
        benefits: "",
        postDate: "",
        tags: "",
        imageLink: '',
        street: "",
        city: "",
        state: "",
        zipCode: "",
      };
    const [jobState, setJobState] = useState(initialState);
    const onChangeField = (event) => {
        const copyState = { ...jobState };
        copyState[event.target.name] = event.target.value;
        setJobState(copyState);
      };


      const saveUserApi = (data) => {
        data.userId= user.id
        axios
          .post("http://localhost:8000/jobs", data)
          .then(() => alert("Job Advertisment added"));
      };
      const onClicked = (e) => {
    

        console.log(jobState)
        saveUserApi(jobState);

    
      };

  return (
       <div className="">
    
          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Company name</label>
              <input
                type="text"
                className="form-control"
                name="companyName"
                placeholder="Company name"
                defaultValue={jobState.companyName}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>

          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Description</label>
              <input
                type="text"
                className="form-control"
                name="description"
                placeholder="Description"
                defaultValue={jobState.description}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Benefits</label>
              <input
                type="text"
                className="form-control"
                name="benefits"
                placeholder="Benefits"
                defaultValue={jobState.benefits}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Post Date</label>
              <input
                type="text"
                className="form-control"
                name="postDate"
                placeholder="Post Date"
                defaultValue={jobState.postDate}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Tags</label>
              <input
                type="text"
                className="form-control"
                name="tags"
                placeholder="Tags"
                defaultValue={jobState.tags}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Image Link</label>
              <input
                type="text"
                className="form-control"
                name="imageLink"
                placeholder="Image Link"
                defaultValue={jobState.imageLink}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Street</label>
              <input
                type="text"
                className="form-control"
                name="street"
                placeholder="street"
                defaultValue={jobState.street}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>

          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>city</label>
              <input
                type="text"
                className="form-control"
                name="city"
                placeholder="city"
                defaultValue={jobState.city}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    

          </div>
         
         <br></br>

          

          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>State</label>
              <input
                type="text"
                className="form-control"
                name="state"
                placeholder="state"
                defaultValue={jobState.state}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>

          <br></br>

          <div className="form-row">
            
            <div className="form-group col-md-6 inputToleft">
              <label>Zip Code</label>
              <input
                type="text"
                className="form-control"
                name="zipCode"
                placeholder="zipCode"
                defaultValue={jobState.zipCode}
                onChange={(event) => onChangeField(event)}
              ></input>
            </div> 
    
          </div>
          <button className="btn btn-primary" 
          onClick={onClicked}>
            Add
          </button>
          {"         "}
          <button className="btn btn-primary" 
          onClick={onClicked}>
            Edit
          </button>
        </div>

  )
}

export default AddJob