import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './styles/style.scss';
import './App.css';
import Movies from './components/home/Movies';
import Navbar from './components/navbar/Navbar';
import Login from './components/login/Login';
import Register from './components/register/Register';
import Movie from './components/movie/Movie';
import Watchlist from './components/watchlist/Watchlist';
import Actors from './components/actors/Actors';
import { Logout } from '@mui/icons-material';
import Callback from './components/register/Callback';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route exact path='/' element={<Movies />} />
          <Route exact path='/callback' element={<Callback />} />
          <Route path='/login' element={<Login />} />
          <Route path='/signup' element={<Register />} />
          <Route path='/movies/:id' element={<Movie />} />
          <Route path='/watchlist' element={<Watchlist />} />
          <Route path='/actors/:id' element={<Actors />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
