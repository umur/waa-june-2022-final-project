import React from 'react'
import { useState, useEffect, useRef, useCallback } from 'react'
import { useNavigate } from 'react-router-dom'
import { useSelector } from 'react-redux'
import job from '../../service/job'
import tag from '../../service/tag'
import useCollapse from 'react-collapsed'
import ReactTags from 'react-tag-autocomplete'
import Loading from '../../components/loading'
import './Job.css'

const JobListPage = () => {
    const currentUser = useSelector(state => state.user)
    const [jobList, setJobList] = useState([])
    const [searchQuery, setSearchQuery] = useState("")
    const [selectedFilter, setSelectedFilter] = useState({})
    const [filteredList, setFilteredList] = useState([])
    const [isLoaded, setIsLoaded] = useState(false)
    const { getCollapseProps, getToggleProps, isExpanded } = useCollapse()
    const [tagss, setTags] = useState([])
    const [suggestions, setSuggestions] = useState([])

    const reactTags = useRef()

    const onDelete = useCallback((tagIndex) => {
        setTags(tagss.filter((_, i) => i !== tagIndex))
    }, [tagss])

    const onAddition = useCallback((newTag) => {
        setTags([...tagss, newTag])
    }, [tagss])

    const navigate = useNavigate();

    const onClicked = (id) => {
        navigate('/job/' + id)
    }

    useEffect(() => {
        if (currentUser?.id) {
            job.findAll().then(resp => {
                setJobList(resp.data)
                setFilteredList(resp.data)
                setIsLoaded(true)
            }).catch(err => {
                console.log(err);
            })
            tag.findAll().then(resp => {
                setIsLoaded(false)
                setSuggestions(resp.data)
                setIsLoaded(true)
            }).catch(err => {
                console.log(err);
            })
        }
    }, [])

    const handleSearch = (e) => {
        e.preventDefault();
        if (selectedFilter === 'all' && !searchQuery) {
            return setFilteredList(jobList)
        } else if (selectedFilter && searchQuery) {
            if (selectedFilter === "company") {
                return setFilteredList(jobList.filter((item) => item.company === searchQuery));
            }
            if (selectedFilter === "city") {
                return setFilteredList(jobList.filter((item) => item.city === searchQuery));
            }
            if (selectedFilter === "state") {
                return setFilteredList(jobList.filter((item) => item.states === searchQuery));
            }
        }
    }

    const handleSearchTag = (e) => {
        e.preventDefault();
        if (tagss.length === 0) {
            setFilteredList(jobList)
        } else {
            let data = []
            jobList.forEach((j) => {
                j.tags.forEach((js) => {
                    tagss.forEach((t) => {
                        if (js.name == t.name) {
                            data.push(j)
                        }
                    })
                });
                setFilteredList(data);
            })
        }
    }

    if (!isLoaded) {
        return (
            <Loading></Loading>
        )
    } else if (isLoaded) {
        return (
            <div className="container mt-5">
                <div className="card">
                    <div className="card-header">
                        <div className="row">
                            <div className="col-6">
                                <h3><u>Job List:</u></h3>
                            </div>
                        </div>
                        <br />
                        <div className="row">
                            <div className="col-12">
                                <h5 {...getToggleProps()}>{isExpanded ? 'Search Collapse' : 'Search Expand'}
                                </h5>
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
                                                    <option value="company">Filter by Company Name</option>
                                                    <option value="city">Filter by City</option>
                                                    <option value="state">Filter by State</option>
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
                                        <br />
                                        <div className="row">
                                            <div className="col-10">
                                                <p>Write the job tags you are interested below:</p>
                                                <ReactTags
                                                    ref={reactTags}
                                                    tags={tagss}
                                                    suggestions={suggestions}
                                                    noSuggestionsText='No matching tags'
                                                    onDelete={onDelete}
                                                    onAddition={onAddition}
                                                />
                                            </div>
                                            <div className="col-2">
                                                <br />
                                                <button
                                                    className="btn btn-success button-margins"
                                                    onClick={(e) => { handleSearchTag(e) }}
                                                >
                                                    Search</button>
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
                                    <th scope='col'>#</th>
                                    <th scope='col'>Title</th>
                                    <th scope='col'>Company</th>
                                    <th scope='col'>City</th>
                                    <th scope='col'>State</th>
                                    <th scope='col'>Salary</th>
                                    <th scope='col'></th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    filteredList.map((item, ind) =>
                                        <tr key={item.id}>
                                            <th scope='row'>{ind + 1}</th>
                                            <td>{item.title ?? ""}</td>
                                            <td>{item.company ?? ""}</td>
                                            <td>{item.city ?? ""}</td>
                                            <td>{item.states ?? "-"}</td>
                                            <td>${item.salary ?? ""}</td>
                                            <td>
                                                <button
                                                    className="btn btn-info"
                                                    onClick={() => {
                                                        onClicked(item.id)
                                                    }}
                                                >Detail
                                                </button>
                                            </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }

}

export { JobListPage }