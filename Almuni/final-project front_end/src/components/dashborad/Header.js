import React, { useContext, useEffect, useState } from 'react'
import {useNavigate} from 'react-router'
import { UserContext } from '../../context/context';

const Header = () => {
  const {user, setUser}= useContext(UserContext)


  const [currentUser, setCurrentUser] = useState(user)



  const navigate = useNavigate();

  const [signedIn, setSignedIn]= useState(currentUser?true:false)
  useEffect(()=>{

    if (currentUser) setSignedIn(false)
    else setSignedIn(true)

  }, [user])

  console.log(user)

const onClickedSignIn=()=>{
setSignedIn(true)
  navigate("/home/signin")
}

const onClickedSignOut=()=>{
  
setSignedIn(false)
setUser({})
setCurrentUser({})
  navigate("/home/signin")
}
const onClickedHome=()=>{
  navigate('/')
}



  return (


    <div>
        <nav className="navbar navbar-dark bg-dark">
        <div className="container-fluid">
        <a className="navbar-brand" href="#">Alumni Management Portal</a>
        {/* <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button> */}

      
      {/* {

        currentUser?

        (
          <div style={{color:'white'}}>
          Welcome {user.fname +" "+user.lname}
          </div>
): ''

      } */}
      
      
    <div className="collapse navbar-collapse" id="navbarNav">
    <ul className="navbar-nav">
        <li className="nav-item">
          <a className="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        </ul>
        </div>
        <form className="d-flex" role="search">
        <div  onClick={()=>{onClickedHome()}}>
        <a className="navbar-brand" href="#">Home</a>
        </div>
        {/* <div  >
        <a className="navbar-brand" href="#">Student</a>
        </div>
        
        <div>
        <a className="navbar-brand" href="#">Faculty</a>
        </div> */}

        {


          currentUser?
          (
            <div  onClick={()=>{onClickedSignOut()}}>
            <a className="navbar-brand">SignOut</a>
            </div>
            
            
          ):
          (
            ''
          )
        }
       
      {/* <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      <button className="btn btn-outline-success" type="submit">Search</button> */}
    </form>
    </div>
    </nav>
    </div>
    
  )
}

export default Header
{/* <h1>Welcome to Almuni Portal App</h1> */}