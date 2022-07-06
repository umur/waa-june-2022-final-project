import { makeStyles } from "@material-ui/core";
import React from "react";
import { Link } from "react-router-dom";


const useStyles = makeStyles((theme) => ({
    navlinks: {
      marginLeft: theme.spacing(10),
      display: "flex",
    },
   logo: {
      flexGrow: "1",
      cursor: "pointer",
    },
    link: {
      textDecoration: "none",
      color: "white",
      fontSize: "20px",
      marginLeft: theme.spacing(5),
      "&:hover": {
        color: "yellow",
        borderBottom: "1px solid white",
      },
    },
  }));

export default function Header() {
    const classes = useStyles();
    return (
        <div className="">
            <Link to='/' className={classes.link}>HomePage</Link>
            <Link to='/' className={classes.link}>Student</Link>
            <Link to='/' className={classes.link}>Faculty</Link>
        </div>
    )
}