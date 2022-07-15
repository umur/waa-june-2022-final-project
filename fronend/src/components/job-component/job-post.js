import React, { Component } from "react";
import Multiselect from "multiselect-react-dropdown";
import ApiService from "../../services/ApiService";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import StateList from '../../state-data';
// const notify = () => toast.info("Wow so easy!");

let selectTag = [];

class JobPost extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tags: [],
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    ApiService.getAllData(ApiService.TAG_LIST).then((res) => {
      this.setState({ tags: res.data.tagList });
      console.log(res.data.tagList);
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
    let modifiedTag = selectTag.map(function (element) {
      return element.tags;
    });
    const data = {
      id: null,
      description: this.state.description,
      tag: modifiedTag,
      state: this.state.state,
      city: this.state.city,
      companyName: this.state.companyName,
    };
    ApiService.postData(ApiService.JOB_POST, data).then(
      (res) => {
        // const navigate = useNavigate();
        // navigate("/job-list");
        // this.props.navigate('/crime');
        toast.success("Data Save Success", {
          position: "top-right",
          autoClose: 2000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSelect(selectedList, selectedItem) {
    selectTag = selectedList;
  }

  onRemove(selectedList, removedItem) {
    selectTag = selectedList;
  }

  render() {
    return (
      <div className="container">
        <h1>Job Post</h1>
        <hr />
        <form className="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
            <div className="col-md-6">
              <label>Description:</label>
              <input
                type="text"
                className="form-control"
                name="description"
                //  value={inputs.description || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-6">
              <label>Tag:</label>
              <Multiselect
                options={this.state.tags}
                onSelect={this.onSelect}
                onRemove={this.onRemove}
                displayValue="tags"
              />
            </div>
            <div className="col-md-4">
              <label>State:</label>
              {/* <input
                type="text"
                className="form-control"
                name="state"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              /> */}

              <select className="form-control" name="state"
                //  value={inputs.state || ""}
                onChange={this.handleChange}>
                <option> Select User</option>
                {StateList.map((result) => (
                  <option title={result.name}>{result.name}</option>
                ))}
              </select>
            </div>
            <div className="col-md-4">
              <label>City:</label>
              <input
                type="text"
                className="form-control"
                name="city"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-4">
              <label>Company Name:</label>
              <input
                type="text"
                className="form-control"
                name="companyName"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-12">
              <br />
              <button className="btn btn-success float-right">
                <span>Save</span>
              </button>
            </div>
          </div>
        </form>
        <ToastContainer />
      </div>
    );
  }
}

export default JobPost;
