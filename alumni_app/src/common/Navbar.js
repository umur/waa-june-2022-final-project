import React, { useContext, useEffect } from "react";
import { makeStyles } from '@material-ui/core/styles';
import Header from "../pages/dashboard/Header";
import { AppBar, IconButton, Toolbar, Typography } from "@material-ui/core";
import { useNavigate } from "react-router";
import { AUTHCONTEXT } from "../App";

const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
    },
}));

export default function Navbar() {
    const classes = useStyles();
    const navigate = useNavigate();
    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar variant="dense">
                    <Typography variant="h6" color="inherit">
                        <span onClick={() => { navigate('/') }} className="pointer">  Alumini Management Portal</span>
                    </Typography>
                    <IconButton edge="start"
                        className={classes.root}
                        color="inherit" aria-label="menu">
                        <Header></Header>
                    </IconButton>
                </Toolbar>
            </AppBar>
        </div>
    );
}