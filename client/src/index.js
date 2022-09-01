import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import "bootstrap/dist/css/bootstrap.min.css";

import HttpService from "./services/HttpService";
import UserService from "./services/UserService";

const initReact = () => {
  const root = ReactDOM.createRoot(document.getElementById("root"));
  root.render(
    // <React.StrictMode>
      <App />
    // </React.StrictMode>
  );
};

UserService.initKeycloak(initReact);
HttpService.configure();

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
