import React, { Component } from 'react'
import {FaUserCircle} from 'react-icons/fa';

class NavbarHome extends Component {
    state = {  } 
    render() { 
        console.log("🚀 ~ file: NavbarHome.jsx ~ line 7 ~ NavbarHome ~ render ~ render")
        return (
        <div className="app-bar-header">
                <nav className="navbar navbar-expand-lg static-top d-flex justify-content-between app-bar-header">
                    {/* <div className="dropdown">
                        <a className="nav-link" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <FaUserCircle style={{color: '#292929', width: '40px', height: '40px'}}/>
                        </a>
                        <ul className="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a className="dropdown-item text-center" href="#">ورود</a></li>
                            <li><a className="dropdown-item text-center" href="#">ثبت نام</a></li>
                        </ul>
                    </div> */}

                    <div className="nav-sort-search-bar">
                        <div className="nav-search-bar">
                            <span className="iconify" data-icon="ant-design:search-outlined" style="color: #b12025;" data-width="25" data-height="25"></span>
                            <form className="d-flex">
                                <input className="form-control" type="search" aria-label="Search"/>
                            </form>
                        </div>
                        <div className="dropdown">
                            <button className="btn btn-light" id="filter" data-bs-toggle="dropdown" aria-expanded="false">
                                <span className="iconify" data-icon="fe:drop-down" style="color: #b12025;" data-width="25" data-height="25"></span>
                                <span>جست و جو بر اساس:</span>
                            </button>

                            <ul className="dropdown-menu" aria-labelledby="filter">
                                <li><a className="dropdown-item text-center" href="#">نام</a></li>
                                <li><a className="dropdown-item text-center" href="#">ژانر</a></li>
                                <li><a className="dropdown-item text-center" href="#">تاریخ</a></li>
                            </ul>
                        </div>
                    </div>
            
                     <img class="nav-brand" src="./../../assets/images/logo.png" alt=""/>
                </nav>
        </div>
        );
    }
}
 
export default NavbarHome;