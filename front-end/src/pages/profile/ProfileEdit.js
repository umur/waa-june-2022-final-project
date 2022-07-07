import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'
import { useSelector } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import profile from '../../service/profile'

const ProfileEdit = () => {

    const [user, setUser] = useState({})
    const [loading, setLoading] = useState(false)
    const [submitted, setSubmitted] = useState(false)
    const [errorMessage, setErrorMessage] = useState("")
    const currentUser = useSelector(state => state.user)

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;

        setUser((prevState => {
            return {
                ...prevState,
                [name]: value
            }
        }));
    }

    const handleCancel = (e) => {
        e.preventDefault();
        navigate('/profile')
    }

    const handleRegister = (e) => {
        e.preventDefault();
        console.log('submit clicked');
        console.log(user)
    }

    useEffect(() => {
        if (currentUser?.id) {
            profile.getMe().then(resp => {
                setUser(resp.data);
            }).catch(err => {
                console.log(err);
            })
        }
    }, [])

    console.log(user);

    return (
        <div className="container mt-5">
            <form
                onSubmit={(e) => handleRegister(e)}
                noValidate
            >
                <div className="form-row">
                    <div className="form-group col-md-6">
                        <label htmlFor="firstname">First Name</label>
                        <input
                            type="text"
                            className="form-control"
                            name="firstname"
                            value={user.firstName}
                            onChange={(e) => handleChange(e)}
                            placeholder="First Name" />
                    </div>
                    <div className="form-group col-md-6">
                        <label htmlFor="lastname">Last Name</label>
                        <input
                            type="text"
                            className="form-control"
                            name="lastname"
                            value={user.lastName}
                            onChange={(e) => handleChange(e)}
                            placeholder="Last Name" />
                    </div>
                </div>
                <div className="form-row">
                    <div className="form-group col-md-12">
                        <label
                            htmlFor="address">Street</label>
                        {
                            user.address &&
                            <input
                                type="text"
                                className="form-control"
                                name="address"
                                value={user.address.street}
                                onChange={(e) => handleChange(e)}
                                placeholder="1234 Main St" />
                        }

                    </div>
                </div>

                <div className="form-row">
                    <div className="form-group col-md-6">
                        <label htmlFor="city">City</label>
                        <input
                            type="text"
                            className="form-control"
                            name="city"
                            // value={user.address ? user.address.city : ''}
                            onChange={(e) => handleChange(e)}
                            placeholder='City' />
                    </div>
                    <div className="form-group col-md-4">
                        <label htmlFor="state">State</label>
                        <input
                            type="text"
                            className="form-control"
                            name="state"
                            // value={user.address ? user.address.state : ''}
                            onChange={(e) => handleChange(e)}
                            placeholder='State' />
                        {/* <select
                            name="state"
                            className="form-control"
                            defaultValue={user.address ? user.address.state : ''}
                        >
                            <option selected>Choose...</option>
                            <option>IA</option>
                            <option>IL</option>
                        </select> */}
                    </div>
                    <div className="form-group col-md-2">
                        <label htmlFor="zip">Zip</label>
                        <input
                            type="text"
                            className="form-control"
                            name="zip"
                            // value={user.address ? user.address.zip : ''}
                            onChange={(e) => handleChange(e)}
                            placeholder='Zip' />
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-3">
                        <button onClick={(e) => { handleCancel(e) }} className="btn btn-warning m-2">Cancel</button>
                        <button className="btn btn-primary m-2">Save</button>
                    </div>
                </div>
            </form >
        </div >
    )
}

export { ProfileEdit }