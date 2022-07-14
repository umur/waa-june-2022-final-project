import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import axios from 'axios';
import { useLocation } from 'react-router-dom';

const ResetPassword = () => {
    const search = useLocation().search;
    const token = new URLSearchParams(search).get('token');
    const [status, setStatus] = useState(false);


    const { register, handleSubmit, watch, formState: { errors } } = useForm({
        defaultValues: {
            password: "",
            confirmPassword: ""
        }
    });


    const message = () => {
        return (
            <p className='text-primary'>Successfully Updated password, click <a className='text-warning' href='/login'>here</a> to login</p>
        )
    }

    const onSubmit = async (data) => {
        const res = await axios.post(`http://localhost:8080/api/v1/uaa/reset-password?token=${token}`, data);
        // console.log(res.data);
        if (res.status === 200) {
            setStatus(true);
        }
    }

    return (
        <div className='hold-transition login-page'>
            <div className="login-box">
                <div className="login-logo">
                    <h4>Property Management</h4>
                </div>
                <div className="card">
                    <div className="card-body login-card-body">
                        <p className="login-box-msg">Enter your new password</p>
                        <form action="" method="post" onSubmit={handleSubmit(onSubmit)}>
                            <div className="input-group mb-3">
                                <input
                                    type="password"
                                    {...register("password", { required: 'Password is required' })}
                                    className="form-control"
                                    placeholder="Password" />
                                <p className='text-danger'>{errors.password?.message}</p>
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-lock" />
                                    </div>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <input
                                    type="password"
                                    className="form-control"
                                    {...register(
                                        "confirmPassword",
                                        {
                                            required: 'Confirm Password is required',
                                            validate: (val) => {
                                                if (watch('password') !== val) {
                                                    return "Your passwords do no match";
                                                }
                                            },
                                        }
                                    )
                                    }
                                    placeholder="Retype password" />
                                <p className='text-danger'>{errors.confirmPassword?.message}</p>
                                <div className="input-group-append">
                                    <div className="input-group-text">
                                        <span className="fas fa-lock" />
                                    </div>
                                </div>
                            </div>
                            {status ? message() : ''}
                            <div className="row">
                                <div className="col-12">
                                    <input
                                        type="submit"
                                        className="btn btn-primary btn-block"
                                        value="Reset Password"
                                    />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default ResetPassword