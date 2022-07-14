import React from "react";
import { Button, Typography } from "antd";
import { Link, useNavigate, Navigate, useLocation } from 'react-router-dom';
import "./QrCode.css";

const QrCode = (props) => {
    const { Title } = Typography;
    const { state } = useLocation();
    const navigate = useNavigate();

    console.log(state);

    return (
        <div className="qrcode-container">
            <Title level={4}>Scan the QrCode using authenticator app</Title>
            <img src={state.imageUrl} />
            <Button
                onClick={() => navigate("/login")}
                shape="round"
                className="login-form-button"
                size="large"
            >
                Continue to login
            </Button>
        </div>
    );
};

export default QrCode