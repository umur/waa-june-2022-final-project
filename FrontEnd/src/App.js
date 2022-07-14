import logo from './logo.svg';
import './App.css';

import AddExperiance from './components/AddExperience';
import AddAdvertisement from './views/AddAdvertisement';
import EnhancedTable from './components/StudentAdvertisements';
import StudentAdvertisements from './components/StudentAdvertisements';
import { Route,Routes } from 'react-router-dom';
import {Home} from './components/Home';
import Profile from './components/Profile';
import Header from './components/Header';
import ExploreJobs from './components/ExploreJobs';
import JobDetails from './components/JobDetails';
import { Footer } from './components/Footer';
function App() {

 
  //
  return (
  <div>
    <Header></Header>
<Routes>
        <Route path="/" element={<Home />} />
        <Route path="Profile" element={<Profile />} />
        <Route path="Experience" element={<AddExperiance />} />
        <Route path="MyAds"  element={<StudentAdvertisements />} />
        <Route path="ExploreJobs"  element={<ExploreJobs />} />
        <Route path="JobDetails"  element={<JobDetails />} />
      </Routes>
     <Footer></Footer>
    </div>
  );
}

export default App;
