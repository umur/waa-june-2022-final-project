import React from "react";
import { Routes, Route } from "react-router";
import HomePage   from './HomePage'
import Header from "./Header";

const MyRouter = () => {
  return (
    <div>
      MyRouter
      <Routes>
        <Route path="/home"  exact element={<HomePage/>}></Route>
        <Route path="/home/header" element={<Header/>}></Route>
      </Routes>
    </div>
  );
};

export default MyRouter;
