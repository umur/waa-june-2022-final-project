import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import "./index.css";
import { getStudentList } from "../../redux/reducers/Student/actions"
function StudentFilter(props) {
  const dispatch = useDispatch();
  const { studentList } = useSelector((state) => state.studentList);

  useEffect(() => {
    dispatch(getStudentList());
  }, []);

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
    let filteredData = filterByTitle([].concat(studentList));
    filteredData = filterByCity(filteredData);
    filteredData = filterByState(filteredData);
    filteredData = filterByTags(filteredData);

    return filteredData;
  };

  const filterByTitle = (data) => {
    if (!filterForm.title) return data;

    return data.filter((x) => {
      return x.description
        .toLowerCase()
        .includes(filterForm.title.toLowerCase());
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

  const filterByTags = (data) => {
    return data;
  };


  const cityList = [
    ...new Set(studentList.map((data) => data.address?.city)),
  ];

  const stateList = [
    ...new Set(studentList.map((data) => data.address?.state)),
  ];

  useEffect(() => {
    let filteredData = filterChanged();
    if (filteredData) props.handleFilterChange(filteredData);
  }, [studentList]);

  return (
    <div className="card filter-form">
      <form onSubmit={handleFilter}>
        <div className="row">
          <div className="mb-3 col-3">
            <label for="name" className="form-label">
              Name
            </label>
            <input type="text" className="form-control" id="name" onChange={handleChange}/>
          </div>

          <div className="mb-3 col-3">
            <label for="state" className="form-label">
              State
            </label>
            <select className="form-select" id="state" onChange={handleChange}>
              <option selected>Select</option>
              <option value="1">Iowa</option>
              <option value="2">New York</option>
              <option value="3">Berlinton</option>
            </select>
          </div>

          <div className="mb-3 col-3">
            <label for="city" className="form-label">
              City
            </label>
            <select className="form-select" id="city" onChange={handleChange}>
              <option selected>Select</option>
              <option value="1">Fairfield</option>
              <option value="2">De Moinse</option>
              <option value="3">Berlinton</option>
            </select>
          </div>

          <div className="mb-3 col-3">
            <label for="major" className="form-label">
              Major
            </label>
            <select className="form-select" id="major" onChange={handleChange}>
              <option selected>Select</option>
              <option value="1">Compro</option>
              <option value="2">MSD</option>
              <option value="3">MBA</option>
            </select>
          </div>
        </div>
      </form>
    </div>
  );
}

export default StudentFilter;
