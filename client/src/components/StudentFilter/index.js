import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import "./index.css";
import { getStudentList } from "../../redux/reducers/Student/actions";
import { Button, Form } from "react-bootstrap";

function StudentFilter(props) {
  const dispatch = useDispatch();
  const { students } = useSelector((state) => state.students);

  useEffect(() => {
    dispatch(getStudentList());
  }, []);

  const [filterForm, setFilterForm] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFilterForm({
      ...filterForm,
      [name]: value,
    });
  };

  const handleFilter = (e) => {
    e.preventDefault();
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  };

  const filterChanged = () => {
    let filteredData = filterByName([].concat(students));
    filteredData = filterByCity(filteredData);
    filteredData = filterByState(filteredData);
    filteredData = filterByMajor(filteredData);

    return filteredData;
  };

  const filterByName = (data) => {
    if (!filterForm.name) return data;

    return data?.filter((x) => {
      return (x.firstName || x.lastName)
        .toLowerCase()
        .includes(filterForm.name.toLowerCase());
    });
  };

  const filterByCity = (data) => {
    if (!filterForm.city) return data;
    return data.filter((x) => {
      return x.address.city
        .toLowerCase()
        .includes(filterForm.city.toLowerCase());
    });
  };

  const filterByState = (data) => {
    if (!filterForm.state) return data;

    return data.filter((x) => {
      return x.address.state
        .toLowerCase()
        .includes(filterForm.state.toLowerCase());
    });
  };

  const filterByMajor = (data) => {
    return data;
  };

  const cityList = [...new Set(students?.map((data) => data.address?.city))];

  const stateList = [...new Set(students?.map((data) => data.address?.state))];

  useEffect(() => {
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  }, [students]);

  return (
    <div className="card filter-form">
      <Form onSubmit={handleFilter}>
        <div className="row">
          <div className="mb-3 col-3">
            <label className="form-label">Name</label>
            <input
              type="text"
              name="name"
              className="form-control"
              id="name"
              onChange={handleChange}
            />
          </div>

          <Form.Group className="mb-2 col-2">
            <Form.Label className="form-label">State</Form.Label>
            <Form.Select
              className="form-select"
              name="state"
              id="state"
              onChange={handleChange}
            >
              s<option>Select</option>
              {stateList?.map((state, index) => {
                return (
                  <option key={index} value={state}>
                    {state}
                  </option>
                );
              })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label className="form-label">City</Form.Label>
            <Form.Select
              className="form-select"
              name="city"
              id="city"
              onChange={handleChange}
            >
              <option>Select</option>
              {cityList?.map((city, index) => {
                return (
                  <option key={index} value={city}>
                    {city}
                  </option>
                );
              })}
            </Form.Select>
          </Form.Group>

          <Form.Group className="mb-2 col-2">
            <Form.Label className="form-label">Major</Form.Label>
            <Form.Select
              className="form-select"
              name="major"
              id="major"
              onChange={handleChange}
            >
              <option>Select</option>
              <option value="Compro">Compro</option>
              <option value="MSD">MSD</option>
              <option value="MBA">MBA</option>

              {/* {students?.map((major, index) => {
                return(
                  <option key={index} value={major} >{major}</option>
                )
              })} */}
            </Form.Select>
          </Form.Group>
          <Form.Group className="mb-1 col-1">
            <Form.Label htmlFor="tagName" className="form-label"></Form.Label>
            <Button
              type="submit"
              className="form-control d-flex"
              variant="info"
            >
              {" "}
              Submit{" "}
            </Button>
          </Form.Group>
        </div>
      </Form>
    </div>
  );
}

export default StudentFilter;
