import { width } from '@mui/system';
import React, { Component } from 'react';
import {FaUserCircle} from 'react-icons/fa';

class Navbar extends Component {
    state = {  } 
    render() { 
        return (
            <nav className="navbar navbar-expand-lg static-top d-flex justify-content-between">
                <div className="dropdown">
                    <a className="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <FaUserCircle style={{color: '#292929', width: '40px', height: '40px'}}/>
                    </a>
                    <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a className="dropdown-item text-center" href="#">salehi@gmail.com</a></li>
                        <li><a className="dropdown-item text-center" href="#">خروج</a></li>
                    </ul>
                </div>

                <img className="nav-brand" src="./../../assets/images/logo.png" alt="logo"/>
            </nav>
        );
    }
}
 
export default Navbar;