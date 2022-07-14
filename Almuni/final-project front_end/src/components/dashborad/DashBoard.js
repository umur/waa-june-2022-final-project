import React from "react";
import Header from "./Header";
import Footer from "./Footer";
import SignIn from '../login/Signin'
//import MyRouter from "./MyRouter";
import HomePage from "./HomePage";
import { Route, Routes } from "react-router";
import SignUp from "../login/SignUp";
import ContactUs from "./ContactUs";
import {Link} from 'react-router-dom'
// import Forgot from '../login/ResetPassword'
import PageNotFound from '../login/File404'
import RegisterSucess from '../login/RegisterSucess'
import Profile from '../body/Profile'
import RessetPassword  from '../login/ResetPassword'
import ForgotPassword from "../login/ForgotPassword";
import FacultySearch from '../body/FacultySearch'
import Student from "../body/Student";
import SampleProfile from "../body/SampleProfile";
import UploadJob from "../body/JobsPage";

const DashBoard = () => {
  return (
    <div className="App">
       {/* <ul>
                <li>
                    <Link to='/home/signin"'>SignIn</Link>
                </li>

                <li>
                    <Link to='/create-person'>Create Person</Link>
                </li>
            </ul> */}

<Header/>
       <Routes>
        <Route path="/" element={<HomePage/>}></Route>
        <Route path="/home/header" element={<Header/>}></Route>
        <Route path="/home/signin" element={<SignIn/>}></Route>
        <Route path="/home/signup" element={<SignUp/>}></Route>
        <Route path="/home/contactUs" element={<ContactUs/>}></Route>
        {/* <Route path="/home/forget-password-reset" element={<Forgot/>}></Route> */}
        <Route path="/signup/sucess" element={<RegisterSucess/>}></Route>
        <Route path="/signup/page-notfound" element={<PageNotFound/>}></Route>
      <Route path="/signup/sucess/profile" element={<Profile/>}></Route>
      <Route path="/home/forget-password-reset" element={<RessetPassword/>}></Route>
      <Route path="/sigin/forgot-password" element={<ForgotPassword/>}></Route>
      <Route path="/siginup/register-sucess" element={<RegisterSucess/>}></Route>
      <Route path="/siginup/faculty" element={<FacultySearch/>}></Route>
      <Route path="/siginup/student" element={<Student/>}></Route>

      <Route path="/jobs/upload" element={<UploadJob/>}></Route>

{/* <Route path="/siginup/student" element={<SampleProfile/>}></Route> */}
      </Routes>
      <Footer />
    </div>
  );
};

export default DashBoard;
