import React, { Component } from "react";
import Multiselect from "multiselect-react-dropdown";
import ApiService from "../../services/ApiService";

export default class JobUpdate extends Component {
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
    const data = {
      id: null,
      description: this.state.description,
      tag: ["Tag 1", "Tag 2"],
      state: this.state.state,
      city: this.state.city,
      companyName: this.state.companyName,
    };
    console.log(data);
    ApiService.postData(ApiService.JOB_POST, data).then(
      (res) => {
        console.log(res);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  onSelect(selectedList, selectedItem) {}

  onRemove(selectedList, removedItem) {}

  render() {
    return (
      <div className="container">
        <h1>Job Post</h1>
        <hr />
        <form class="form-inline" onSubmit={this.handleSubmit}>
          <div className="row">
            <div className="col-md-6">
              <label>Description:</label>
              <input
                type="text"
                class="form-control"
                name="description"
                //  value={inputs.description || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-6">
              <label for="">Tag:</label>
              <Multiselect
                options={this.state.tags}
                onSelect={this.onSelect}
                onRemove={this.onRemove}
                displayValue="tags"
              />
            </div>
            <div className="col-md-4">
              <label>State:</label>
              <input
                type="text"
                class="form-control"
                name="state"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-4">
              <label>City:</label>
              <input
                type="text"
                class="form-control"
                name="city"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-4">
              <label>Company Name:</label>
              <input
                type="text"
                class="form-control"
                name="companyName"
                //  value={inputs.state || ""}
                onChange={this.handleChange}
              />
            </div>
            <div className="col-md-12">
              <br />
              <button className="btn btn-warning">
                <span>Update</span>
              </button>
            </div>
          </div>
        </form>
      </div>
    );
  }
}
