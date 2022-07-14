import React from "react";

import { Typography } from "@material-ui/core";

import Link from "@mui/material/Link";

import "../css/footer.css";

import Home from "@material-ui/icons";



export const Footer = () => {

  return (

    <div className="footer">

      <Typography variant="body2" color="text.secondary" align="center">

        {"Copyright © "}

        <Link color="text.primary" href="https://www.miu.edu/">

          www.alumnimanagement.com

        </Link>{" "}

        {new Date().getFullYear()}

        {"."}

      </Typography>

    </div>

  );

};