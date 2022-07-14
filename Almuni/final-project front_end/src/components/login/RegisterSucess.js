import React from "react";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";

const RegisterSucess = () => {
  const navigate = useNavigate();

  // const onclicked=()=>{
  //     navigate()
  // }
  return (
    <div>
      <div className="text">
        You are Successfully added Thank you fro Registration!
      </div>
      <br></br>
      <div className="decor">
        <Link to="/home/signin"> click here</Link>
        to SignIn.....
      </div>
    </div>
  );
};

export default RegisterSucess;
