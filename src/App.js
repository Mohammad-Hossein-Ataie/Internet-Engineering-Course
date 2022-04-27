import {BrowserRouter ,Route, Routes } from 'react-router-dom';
import './styles/style.scss';
import './App.css';
import Movies from './components/home/Movies';
import Navbar from './components/navbar/Navbar';
import Login from './components/login/Login';
import Register from './components/register/Register';
import Movie from './components/movie/Movie';
import Watchlist from './components/watchlist/Watchlist';
import Actors from './components/actors/Actors';

function App() {
  return (
    <>
      {/* <Navbar/> */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Movies/>}/>
          <Route path='/login' element={<Login/>}/>
          <Route path='/register' element={<Register/>}/>
          <Route path='/movie' element={<Movie/>}/>
          <Route path='/watchlist' element={<Watchlist/>}/>
          <Route path='/actors' element={<Actors/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
