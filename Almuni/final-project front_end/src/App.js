import logo from './logo.svg';
import './App.css';
import DashBoard from './components/dashborad/DashBoard';
import { BrowserRouter } from 'react-router-dom';
import { createContext, useContext, useEffect, useState } from 'react';
import { UserContext } from './context/context';
import axios from 'axios';


export const JobContext= createContext()

function App() {

 const user = useContext(UserContext);
 const [job, setJob]= useState([]);


 useEffect(()=>{


  axios.get('http://localhost:8000/jobs')
  .then(d=>{
    setJob(d.data)
  })

 }, [])



  return (
    <div className="App">
      
      <JobContext.Provider value= {job}>
          <BrowserRouter>
              <DashBoard/>
          </BrowserRouter>
     
      </JobContext.Provider>
     
       
    </div>
  );
}

export default App;
