import './App.css';
import { NavBar } from './components/nav-bar'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import { LoginPage } from './pages/login/LoginPage'
import { SignupPage } from './pages/signup/SignupPage'
import { NotfoundPage } from './pages/error/NotFound';
import { UnauthorizedPage } from './pages/unauthorized/Unauthorized';
import { ProfilePage } from './pages/profile/ProfilePage';
import { ProfileEdit } from './pages/profile/ProfileEdit';
import HomePage from './pages/home/HomePage';
import { UsersPage } from './pages/admin/UsersPage';
import { StudentPage } from './pages/users/StudentPage';
import { StudentDetailPage } from './pages/users/StudentDetail';
import { JobListPage } from './pages/job/JobListPage';
import { JobsDetailPage } from './pages/job/JobDetailPage';
import JobsRecent from './pages/job/JobRecent';
import { ChartsPage } from './pages/charts/ChartsPage';

function App() {
  return (
    <BrowserRouter>
      <NavBar />

      <div className='container'>
        <Routes>
          <Route path='/home' element={<HomePage />} />
          <Route path='/users' element={<UsersPage />} />
          <Route path='/students' element={<StudentPage />} />
          <Route path='/student/:id' element={<StudentDetailPage />} />
          <Route path='/jobs' element={<JobListPage />} />
          <Route path='/job/:id' element={<JobsDetailPage />} />
          <Route path='/applied-jobs' element={<JobsRecent />} />
          <Route path='/profile' element={<ProfilePage />} />
          <Route path='/profile/user/:id' element={<ProfileEdit />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/signup" element={<SignupPage />} />
          <Route path='/charts' element={<ChartsPage />} />
          <Route path="/403" element={<UnauthorizedPage />} />
          <Route path="*" element={< NotfoundPage />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
