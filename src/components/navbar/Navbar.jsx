import React, { Component } from 'react';
import { FaUserCircle } from 'react-icons/fa';
import Dropdown from 'react-bootstrap/Dropdown';
import { DOMAIN } from '../../config/config';
class Navbar extends Component {
    state = {
    }

    handlLogoutClick = () => {
        localStorage.setItem("user", "");
        console.log("user2", localStorage.getItem("user"));
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

                    <Dropdown.Menu>
                        <Dropdown.Item href="/">{localStorage.getItem("user")}</Dropdown.Item>
                        <Dropdown.Item href="/watchlist" target="_blank">لیست مشاهده</Dropdown.Item>
                        <Dropdown.Item href="/" onClick={() => this.handlLogoutClick()}>خروج</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>

                <img className="nav-brand" src="./../../assets/images/logo.png" alt="logo" />
            </nav>
        );
    }

}

export default Navbar;