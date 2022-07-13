import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import "./index.css";
import { getStudentsList } from "../../redux/reducers/Student/actions"

function StudentFilter(props) {
  const dispatch = useDispatch();
  const students  = useSelector((state) => state.students);

  useEffect(() => {
    dispatch(getStudentsList());
  }, []);

  console.log(students)
  const [filterForm, setFilterForm] = useState({});

  const handleChange = (e) => {
    const {name, value} = e.target;
    setFilterForm({
      ...filterForm,
      [name]: value
    });
  };

  const handleFilter = (e) => {
    e.preventDefault();
    let filteredData = filterChanged();
    if(filteredData) props.handleFilterChange(filteredData);
  }

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


  const cityList = [
    ...new Set(students?.map((data) => data.address?.city)),
  ];

  const stateList = [
    ...new Set(students?.map((data) => data.address?.state)),
  ];

  useEffect(() => {
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  }, [students]);

  return (
    <div className="card filter-form">
      <form onSubmit={handleFilter}>
        <div className="row">
          <div className="mb-3 col-3">
            <label className="form-label">
              Name
            </label>
            <input type="text" name="name" className="form-control" id="name" onChange={handleChange}/>
          </div>

          <div className="mb-3 col-3">
            <label className="form-label">
              State
            </label>
            <select className="form-select" name="state" id="state" onChange={handleChange}>s
              <option>Select</option>
              {stateList?.map((state, index) => {
                return(
                  <option key={index} value={state} >{state}</option>
                )
              })}
            </select>
          </div>

          <div className="mb-3 col-3">
            <label className="form-label">
              City
            </label>
            <select className="form-select" name="city" id="city" onChange={handleChange}>
              <option>Select</option>
              {cityList?.map((city, index) => {
                return(
                  <option key={index} value={city} >{city}</option>
                )
              })}
            </select>
          </div>

          <div className="mb-3 col-3">
            <label className="form-label">
              Major
            </label>
            <select className="form-select" name="major" id="major" onChange={handleChange}>
              <option>Select</option>
              {students?.map((major, index) => {
                return(
                  <option key={index} value={major} >{major}</option>
                )
              })}
            </select>
          </div>
        </div>
      </form>
    </div>
  );
}

export default StudentFilter;
