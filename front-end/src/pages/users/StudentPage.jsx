import React, { useState } from 'react'
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import useCollapse from 'react-collapsed';
import { useSelector } from 'react-redux';
import student from '../../service/student';
import Student from './Student.css'
import Loading from '../../components/loading';

const StudentPage = () => {

    const [studentList, setStudentList] = useState([]);
    const [searchQuery, setSearchQuery] = useState("")
    const [selectedFilter, setSelectedFilter] = useState({})
    const [filteredList, setFilteredList] = useState([])
    const { getCollapseProps, getToggleProps, isExpanded } = useCollapse()
    const currentUser = useSelector(state => state.user)
    const [isLoaded, setIsLoaded] = useState(false)

    const navigate = useNavigate();

    const onClicked = (id) => {
        navigate('/student/' + id)
    }

    useEffect(() => {
        if (currentUser?.id) {
            student.findAll().then(resp => {
                setStudentList(resp.data)
                setFilteredList(resp.data)
                setIsLoaded(true)
            }).catch(err => {
                console.log(err);
            })
        }
    }, [])

    // studentList.forEach((e) => {
    //     console.log(e.student);
    // });

    const handleSearch = (e) => {
        e.preventDefault();
        if (selectedFilter === "all" && !searchQuery) {
            return setFilteredList(studentList)
        } else if (selectedFilter && searchQuery) {
            if (selectedFilter === "major") {
                return setFilteredList(studentList.filter((item) => item.student.major === searchQuery))
            }
            if (selectedFilter === "studentId") {
                return setFilteredList(studentList.filter((item) => item.student.studentId === searchQuery))
            }
            if (selectedFilter === "city") {
                return setFilteredList(studentList.filter((item) => item.address.city === searchQuery))
            }
            if (selectedFilter === "state") {
                return setFilteredList(studentList.filter((item) => item.address.state === searchQuery))
            }
            if (selectedFilter === "name") {
                return setFilteredList(studentList.filter((item) => item.firstName === searchQuery))
            }
        } else {
            console.log("Filter or query is null");
        }
    }

    if (!isLoaded) {
        return (
            <Loading></Loading>
        )
    } else if (isLoaded) {
        return (
            <div className="container">
                <div className="pt-5">
                    <div className="card">
                        <div className="card-header">
                            <div className="row">
                                <div className="col-6">
                                    <h3><u>Students:</u></h3>
                                </div>
                            </div>
                            <br />
                            <div className="row">
                                <div className='col-12'>
                                    <h5 {...getToggleProps()}>{isExpanded ? 'Filter Collapse' : 'Filter Expand'}</h5>
                                    <div {...getCollapseProps()}>
                                        <form>
                                            <div className="row">
                                                <div className="col-3">
                                                    <select className='form-select'
                                                        name="category"
                                                        onChange={(e) => setSelectedFilter(e.target.value)}
                                                    >
                                                        <option value="">Select</option>
                                                        <option value="all">All</option>
                                                        <option value="major">Filter by Major</option>
                                                        <option value="studentId">Filter by StudentId</option>
                                                        <option value="city">Filter by City</option>
                                                        <option value="state">Filter by State</option>
                                                        <option value="name">Filter by Name</option>
                                                    </select>
                                                </div>
                                                <div className="col-4">
                                                    <div className="input-group mb3">
                                                        <div className="input-group-prepend">
                                                            <span className="input-group-text">&&</span>
                                                        </div>
                                                        <input className='form-control'
                                                            type="text"
                                                            name="input"
                                                            placeholder="insert value"
                                                            value={searchQuery}
                                                            onChange={(e) => setSearchQuery(e.target.value)}
                                                        />
                                                        <div className="input-group-append">
                                                            <button
                                                                className="btn btn-outline-secondary"
                                                                onClick={(e) => { handleSearch(e) }}
                                                            >Search</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="card-body">
                            <table className="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Student ID</th>
                                        <th scope="col">First Name</th>
                                        <th scope="col">Last Name</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Is Active</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {filteredList.map((item, ind) =>
                                        <tr key={item.id}>
                                            <th scope="row">{ind + 1}</th>
                                            <td>{item.student.studentId ?? ""}</td>
                                            <td>{item.firstName ?? ""}</td>
                                            <td>{item.lastName ?? ""}</td>
                                            <td>{item.email ?? ""}</td>
                                            <td>{item.active ? 'Yes' : 'No'}
                                            </td>
                                            <td>
                                                <button className="btn btn-primary me-1" onClick={() => {
                                                    onClicked(item.id)
                                                }}>
                                                    Detail
                                                </button>
                                            </td>
                                        </tr>
                                    )}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export { StudentPage }