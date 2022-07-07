import React from "react";
// import { AppBar, IconButton, Toolbar, Typography } from "@mui/material";
import { makeStyles } from '@material-ui/core/styles';
import Header from "../pages/dashboard/Header";
import { AppBar, IconButton, Toolbar, Typography } from "@material-ui/core";


const useStyles = makeStyles((theme) => ({
    root: {
        flexGrow: 1,
    },
    menuButton: {
    },
}));

export default function Navbar() {
    const classes = useStyles();

    return (
        <div className={classes.root}>
            <AppBar position="static">
                <Toolbar variant="dense">
                    <Typography variant="h6" color="inherit">
                        Alumini Management Portal
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