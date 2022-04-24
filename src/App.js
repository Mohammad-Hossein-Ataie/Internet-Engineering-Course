import {BrowserRouter ,Route, Routes } from 'react-router-dom';
import './styles/style.scss';
import './App.css';
import Movies from './components/home/Movies.jsx';
import Navbar from './components/navbar/Navbar';
import Login from './components/login/Login';
import Register from './components/register/Register';

function App() {
  return (
    <>
      {/* <Navbar/> */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Movies/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/register' element={<Register/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
