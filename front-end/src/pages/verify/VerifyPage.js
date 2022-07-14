import React, { useEffect, useState } from "react";
import { Form, Input, Button, notification } from "antd";
import { Link, useNavigate, Navigate, useLocation } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { setCurrentUser } from '../../store/actions/user'
import { DingtalkOutlined } from "@ant-design/icons";
import authentication from "../../service/authentication";
import "./VerifyCode.css";


const VerifyCode = (props) => {
    const [loading, setLoading] = useState(false);
    const { state } = useLocation();
    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();
    const dispatch = useDispatch();

    const onFinish = (values) => {
        setLoading(true);

        const verifyRequest = {
            code: values.code,
            username: state.username,
            password: state.password,
        };

        authentication.verify(verifyRequest).then((resp) => {
            dispatch(setCurrentUser(resp.data));
            navigate('/profile');
            setLoading(false);
        }).catch((error) => {
            if (error.status === 400) {
                notification.error({
                    message: "Error",
                    description: "Code is incorrect",
                });
            } else {
                notification.error({
                    message: "Error",
                    description: "Sorry! Something went wrong. Please try again!",
                });
            }
            setLoading(false);
        });
    };

    return (
        <div className="container mt-5">
            <Form
                name="normal_login"
                className="login-form"
                initialValues={{ remember: true }}
                onFinish={onFinish}
            >
                <Form.Item
                    name="code"
                    rules={[{ required: true, message: "Code is required" }]}
                >
                    <Input size="large" placeholder="Enter code" />
                </Form.Item>
                <Form.Item>
                    <Button
                        onClick={() => navigate("/login")}
                        shape="round"
                        size="large"
                    >
                        Cancel
                    </Button>
                    <Button
                        shape="round"
                        size="large"
                        htmlType="submit"
                        className="verify-form-button "
                        loading={loading}
                    >
                        Verify
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
};

export default VerifyCode;