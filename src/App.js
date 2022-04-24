import {BrowserRouter ,Route, Routes } from 'react-router-dom';
import './styles/style.scss';
import './App.css';
import Movies from './components/home/Movies.jsx';
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Movies/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
