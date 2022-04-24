import {BrowserRouter ,Route, Routes } from 'react-router-dom';
import './styles/style.scss';
import './App.css';
import Movies from './components/home/Movies.jsx';
import Navbar from './components/navbar/Navbar';
function App() {
  return (
    <>
      {/* <Navbar/> */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Movies/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
