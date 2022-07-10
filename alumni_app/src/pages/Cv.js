import React from "react";
import FileUpload from "../common/FileUpload";
import { useState } from "react";
import Button from "@material-ui/core/Button";

export default function Cv() {

    const [formValues, setFormValues] = useState([{ name: "", email : ""}]);
    
    const handleChange = (i, e) => {
        let checkValues = [...formValues];
        checkValues[i][e.target.name] = e.target.value;
        setFormValues( checkValues );
      }
    
    const addFormFields = () => {
        setFormValues ([...formValues, { companyName: "", detail: "" }]);
    }
    
      const removeFormFields = (i) => {
        let checkValues = [...formValues];
        checkValues.splice(i, 1);
        setFormValues( checkValues );
      }
    
      const handleSubmit= () => {
        let params = "/jobs/newJob";
        let result = await postRequest(params, values);
        //navigate("/Jobs");
        alert(JSON.stringify(formValues));
      }
    
    return (
        <div>
            <h3>Upload your CV here</h3>
            <FileUpload/>
            
            <h3>Add your job experiences</h3>
            <form >
                {formValues.map((element, index) => (
                <div className="form-inline" key={index}>
                    <label>Company Name</label>
                <br></br>
                <input type="text" name="companyName" defaultValue={element.name || ""} onChange={e => handleChange(index, e)} />
                <br></br>
                <label>Detail</label>
                <br></br>
                <input type="text" name="detail" defaultValue={element.email || ""} onChange={e => handleChange(index, e)} />
              {
                index ? <Button className= "ml-1" width="50px" margin-left="30px" onClick={() => removeFormFields(index)}
                    variant="contained" color="secondary">
                        Remove
                        </Button>: null
              }
            </div>
          ))}
          <div className="button-section">
          <Button width="50px" margin-left="30px" onClick={() => addFormFields()}
                    variant="contained" color="primary">
              Add
            </Button>

            <Button width="50px" margin-left="30px" onClick={() => handleSubmit()}
                    variant="contained" color="Success">
              Submit
            </Button>
              {/* <button className="button add" type="button" onClick={() => addFormFields()}>Add</button>
              <button className="button submit" type="submit">Submit</button> */}
          </div>
      </form>
        </div>
    )
}