import React, { useState, useEffect } from "react";
import { Form, Row } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { allJobAdvertisement } from "../../redux/reducers/JobAdvertisement/actions";


export default function JobFilter(props) {
  const dispatch = useDispatch();
  const { jobAdvertisement } = useSelector((state) => state);

  useEffect(() => {
    dispatch(allJobAdvertisement());
  }, []);

  const [filteredState, setFilteredState] = useState();
  
  let filterChanged = (event) => {
    event.preventDefault();
    let result;
    let input = event.target.value;
    console.log(input)
    if (input) {
      result = jobAdvertisement.filter((str) => {
        return str.title.toLowerCase().includes(input)
      })
    }
    setFilteredState(result ? result : jobAdvertisement);
  }

  let filterByState = (event) => {
    event.preventDefault();
    let result;
    let input = event.target.value;
    console.log(input)
    if (input) {
      result = jobAdvertisement.filter((str) => {
        return str.address.state.toLowerCase().includes(input.toLowerCase())
      })

    }
    setFilteredState(result ? result : jobAdvertisement);
  }

  let filterByCity = (event) => {
    event.preventDefault();
    let result;
    let input = event.target.value;
    console.log(input)
    if (input) {
      result = jobAdvertisement.filter((str) => {
        return str.address.city.toLowerCase().includes(input.toLowerCase())
      })

    }
    setFilteredState(result ? result : jobAdvertisement);
  }

  let filterByTagName = (event) => {
    event.preventDefault();
    let result;
    let input = event.target.value;
    if (input) {
      result = jobAdvertisement.filter((str) => {
        return str.address.state.toLowerCase().includes(input.toLowerCase())
      })

    }
    setFilteredState(result ? result : jobAdvertisement);
  }


  const handleSubmit = (event) => {
    event.preventDefault();
    filterByTagName(event)
    filterByCity(event)
    filterChanged(event)
    filterByState(event)
  }
  return (
    <div className="card filter-form">
      <Form onSubmit={handleSubmit}>
        <Row>
          <Form.Group className="mb-3 col-3">
            <Form.Label htmlFor="name" className="form-label">
              Title
            </Form.Label>
            <Form.Control type="text" className="form-control" id="title" onChange={(event) => filterChanged(event)} name="title"/>
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label htmlFor="state" className="form-label">
              State
            </Form.Label>
            <Form.Select className="form-select" id="state" onChange={(event) => filterByState(event)} name="state">
              <option>Select</option>

              {jobAdvertisement.map((item) => { return <option value={item.address.state}>{item.address.state}</option> })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-3 col-3">
            <Form.Label htmlFor="city" className="form-label">
              City
            </Form.Label>
            <Form.Select className="form-select" id="city" onChange={(event) => filterByCity(event)} name="city">
              <option>Select</option>
              {jobAdvertisement.map((item) => { return <option value={item.address.city}>{item.address.city}</option> })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label htmlFor="tagName" className="form-label">
              Tag Name
            </Form.Label>
            <Form.Control type="text" className="form-control" id="tagName" onChange={(event) => filterByTagName(event)} name="tagname"/>
          </Form.Group>
          <Form.Group className="mb-2 col-2">
            <Form.Label></Form.Label>
            <Form.Control type="submit" value="Search" onClick={() => props.handleFilterChange(filteredState)}/>
          </Form.Group>
        </Row>
      </Form>
    </div>
  );
}
