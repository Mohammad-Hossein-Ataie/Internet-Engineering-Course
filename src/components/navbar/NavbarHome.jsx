import React, { Component } from 'react'
import { FaUserCircle } from 'react-icons/fa';
import { FiSearch } from 'react-icons/fi';
import Dropdown from 'react-bootstrap/Dropdown';
import { DOMAIN } from '../../config/config';
import logoImage from './../../assets/images/logo.png';

class NavbarHome extends Component {
    state = {
        searchedKey: null,
        searchedWord: null
    }
    handleSearchKeySelect = (key) => {
        this.setState({ searchedKey: key });
        this.props.getSearchPar({ key: key, val: this.state.searchedWord })
    }
    handlLogoutClick = () => {
        localStorage.setItem("user", "");
        const url = DOMAIN + '/logout';
        fetch(url);
    }
    render() {
        return (
            <nav className="navbar navbar-expand-lg static-top d-flex justify-content-between">

                <Dropdown>
                    <Dropdown.Toggle className='nav-toggle'>
                        <FaUserCircle style={{ color: '#292929', width: '40px', height: '40px' }} />
                    </Dropdown.Toggle>

                    {localStorage.getItem("user") != "" ?
                        <Dropdown.Menu>
                            <Dropdown.Item href="#">{localStorage.getItem("user")}</Dropdown.Item>
                            <Dropdown.Item href="/watchlist" target="_blank">لیست مشاهده</Dropdown.Item>
                            <Dropdown.Item href="/" onClick={() => this.handlLogoutClick()}>خروج</Dropdown.Item>
                        </Dropdown.Menu> :
                        <Dropdown.Menu>
                            <Dropdown.Item href="/login" target="_blank"> ورود</Dropdown.Item>
                            <Dropdown.Item href="/signup">ثبت نام</Dropdown.Item>
                        </Dropdown.Menu>

                    }
                </Dropdown>

                <div className="nav-sort-search-bar">
                    <div className="nav-search-bar">
                        {/* <FiSearch /> */}
                        <form className="d-flex">
                            <input className="form-control" type="search" aria-label="Search" onChange={e => this.setState({ searchedWord: e.target.value })} />
                        </form>
                    </div>
                    <Dropdown>
                        <Dropdown.Toggle className='nav-toggle'>
                            <span>جست و جو بر اساس</span>
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item href="#" onClick={() => this.handleSearchKeySelect("name")}>نام</Dropdown.Item>
                            <Dropdown.Item href="#" onClick={() => this.handleSearchKeySelect("genre")}>ژانر</Dropdown.Item>
                            <Dropdown.Item href="#" onClick={() => this.handleSearchKeySelect("date")}>تاریخ</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>

                <img className="nav-brand" src={logoImage} alt="logo" />
            </nav>
            // <div className="app-bar-header">
            //         <nav className="navbar navbar-expand-lg static-top d-flex justify-content-between app-bar-header">

            //             <div className="nav-sort-search-bar">
            //                 <div className="nav-search-bar">
            //                     <span className="iconify" data-icon="ant-design:search-outlined" style="color: #b12025;" data-width="25" data-height="25"></span>
            //                     <form className="d-flex">
            //                         <input className="form-control" type="search" aria-label="Search"/>
            //                     </form>
            //                 </div>
            //                 <div className="dropdown">
            //                     <button className="btn btn-light" id="filter" data-bs-toggle="dropdown" aria-expanded="false">
            //                         <span className="iconify" data-icon="fe:drop-down" style="color: #b12025;" data-width="25" data-height="25"></span>
            //                         <span>جست و جو بر اساس:</span>
            //                     </button>

            //                     <ul className="dropdown-menu" aria-labelledby="filter">
            //                         <li><a className="dropdown-item text-center" href="#">نام</a></li>
            //                         <li><a className="dropdown-item text-center" href="#">ژانر</a></li>
            //                         <li><a className="dropdown-item text-center" href="#">تاریخ</a></li>
            //                     </ul>
            //                 </div>
            //             </div>

            //              <img class="nav-brand" src="./../../assets/images/logo.png" alt=""/>
            //         </nav>
            // </div>
        );
    }
}

export default NavbarHome;