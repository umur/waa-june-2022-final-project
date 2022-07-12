import React, { useContext } from "react";
import { Route, Routes } from "react-router";
import Login from "../../pages/sign-in/Login";

export default function RoutePermited() {
    return (
        <Routes>
            <Route path="/Login" element={<Login />}></Route>
            <Route path="*" element={<Login />}></Route>
        </Routes>
    )
}
