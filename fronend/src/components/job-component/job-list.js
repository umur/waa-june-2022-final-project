import React, { Component } from "react";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import ApiService from "../../services/ApiService";
import LoginInfo from "../../services/login-info.service";

class JobList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      jobs: [],
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.applyJob = this.applyJob.bind(this);
  }

  componentDidMount() {
    ApiService.getAllData(ApiService.JOB_LIST).then((res) => {
      this.setState({ jobs: res.data.jobList });
      console.log(res.data.jobList);
    });
  }

  handleChange(event) {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    this.setState({
      [name]: value,
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    const data = {
      tags: this.state.tags,
      state: this.state.state,
      city: this.state.city,
      companyName: this.state.companyName,
    };
    ApiService.postData(ApiService.SEARCH_JOB, data).then(
      (res) => {
        console.log(res.data);
        this.setState({ jobs: res.data.results });
        console.log(res.data.results);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  applyJob(id) {
    const data = {
      jobId: id
    }
    ApiService.postData(ApiService.APPLY_JOB, data).then(
      (res) => {
        toast.success('Apply success', {
          position: "top-right",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
        console.log(res.data);
      },
      (error) => {
        console.log(error);
      }
    );

  }


  render() {
    return (
      <div className="container">
        <form className="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
            <div className="col-md-3">
              <label>Tag Name:</label>
              <input type="text" className="form-control" name="tags"
                //  value={inputs.description || ""}
                onChange={this.handleChange}/>
            </div>
            <div className="col-md-3">
              <label>State:</label>
              <input type="text" className="form-control" name="state"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>City:</label>
              <input type="text" className="form-control" name="city"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>
            <div className="col-md-3">
              <label>Company:</label>
              <input type="text" className="form-control" name="companyName"
                //  value={inputs.description || ""}
                onChange={this.handleChange} />
            </div>

            <div className="col-md-12">
              <br />
              <button className="btn btn-success float-right">
                <span>Search</span>
              </button>
            </div>
          </div>
        </form>


        <h2 className="text-center">Job List</h2>
        <br></br>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th> Description</th>
                <th> State</th>
                <th> City</th>
                <th> Company</th>
                {
                  (LoginInfo.userType() === "STUDENT") && <th>Action</th>
                }
                
              </tr>
            </thead>
            <tbody>
              {this.state.jobs.map((job) => (
                <tr key={job.id}>
                  <td> {job.description} </td>
                  <td> {job.state} </td>
                  <td> {job.city}</td>
                  <td> {job.companyName}</td>
                  {
                  (LoginInfo.userType() === "STUDENT") && <td>
                  {
                    (job.postedBy.email != LoginInfo.username()) ?
                      <button className="btn btn-primary" onClick={() => this.applyJob(job.id)}>A</button> : 
                      <button className="btn btn-warning">U</button> 
                  }
                </td>
                }
                  
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <ToastContainer />
      </div>
    );
  }
}

export default JobList;
