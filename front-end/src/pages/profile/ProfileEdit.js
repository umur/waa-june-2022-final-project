import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { useNavigate } from 'react-router-dom'
import { clearCurrentUser } from '../../store/actions/user'
import profile from '../../service/profile'

const ProfileEdit = () => {

    const [user, setUser] = useState({})
    const [loading, setLoading] = useState(false)
    const [address, setAddress] = useState({})
    const [submitted, setSubmitted] = useState(false)
    const [errorMessage, setErrorMessage] = useState("")
    const currentUser = useSelector(state => state.user)

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;

        if (name === "firstName" || name === "lastName") {
            setUser((prevState => {
                const newUser = { ...prevState }
                newUser[name] = value
                return newUser
            }));
        }
        if (name === "state" || name === "zip" || name === "street" || name === "city") {
            if (user.address) {
                setUser((prevState => {
                    const newAddress = { ...prevState }
                    newAddress.address[name] = value
                    return newAddress
                }))
            } else {
                setAddress((prevState => {
                    const old = { ...prevState }
                    old[name] = value
                    return old;
                }))

            }
        }
    }

    const handleCancel = (e) => {
        e.preventDefault();
        navigate('/profile')
    }

    const handleRegister = (e) => {
        e.preventDefault();
        profile.updateProfile(currentUser?.id, user).then(u => {
            navigate('/profile')
        }).catch(err => {
            console.log(err);
        })
    }

    const logOut = () => {
        dispatch(clearCurrentUser());
        navigate('/login');
    }

    useEffect(() => {
        if (currentUser?.id) {
            profile.getMe().then(resp => {
                setUser(resp.data);
                setLoading(true)
            }).catch(err => {
                console.log(err);
            })
        } else {
            logOut();
        }
    }, [])

    console.log(user);

    if (!loading) {
        return (
            <div className="container mt-5">
                <div>Loading...</div>
            </div >
        )
    } else if (loading) {
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
                                name="firstName"
                                defaultValue={user.firstName ?? ""}
                                onChange={(e) => handleChange(e)}
                                placeholder="First Name" />
                        </div>
                        <div className="form-group col-md-6">
                            <label htmlFor="lastname">Last Name</label>
                            <input
                                type="text"
                                className="form-control"
                                name="lastName"
                                defaultValue={user.lastName ?? ""}
                                onChange={(e) => handleChange(e)}
                                placeholder="Last Name" />
                        </div>
                    </div>
                    <div className="form-row">
                        <div className="form-group col-md-12">
                            <label
                                htmlFor="address">Street</label>
                            <input
                                type="text"
                                className="form-control"
                                name="street"
                                defaultValue={user.address ? user.address.street : ""}
                                onChange={(e) => handleChange(e)}
                                placeholder="1234 Main St" />
                        </div>
                    </div>

                    <div className="form-row">
                        <div className="form-group col-md-6">
                            <label htmlFor="city">City</label>
                            <input
                                type="text"
                                className="form-control"
                                name="city"
                                defaultValue={user.address.city ?? ""}
                                onChange={(e) => handleChange(e)}
                                placeholder='City' />

                        </div>
                        <div className="form-group col-md-4">
                            <label htmlFor="state">State</label>
                            <input
                                type="text"
                                className="form-control"
                                name="state"
                                defaultValue={user.address.state ?? ""}
                                onChange={(e) => handleChange(e)}
                                placeholder='State' />
                        </div>
                        <div className="form-group col-md-2">
                            <label htmlFor="zip">Zip</label>
                            <input
                                type="text"
                                className="form-control"
                                name="zip"
                                defaultValue={user.address.zip ?? ""}
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


}

export { ProfileEdit }