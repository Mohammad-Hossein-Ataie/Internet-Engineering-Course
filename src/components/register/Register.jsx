import React, { Component } from 'react';
import { DOMAIN } from '../../config/config';

class Register extends Component {
    state = {
        email: null,
        password: null,
        nickname: null,
        name: null,
        birthday: null
    }

    handleSignupClick = (e) => {
        const url = DOMAIN + window.location.pathname;

        e.preventDefault();
        fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "email": this.state.email,
                "password": this.state.password,
                "name": this.state.name,
                "nickname": this.state.nickname,
                "birthDate": this.state.birthday
            })
        }).then(res => {
            console.log("res", res);
            if (res.status == 200) {
                localStorage.setItem('user', this.state.email);
                window.location.href = "/";
            }
        });

        console.log("user", localStorage.getItem("user"));
    }

    componentDidMount() {
        document.title = "Signup";
    }

    OnChangeEmail = (e) => {
        this.setState({ email: e.target.value });
    }

    OnChangePassword = (e) => {
        this.setState({ password: e.target.value });
    }

    OnChangenickname = (e) => {
        this.setState({ nickname: e.target.value });
    }

    OnChangeName = (e) => {
        this.setState({ name: e.target.value });
    }

    OnChangeBirthday = (e) => {
        this.setState({ birthday: e.target.value });
    }
    render() {
        return (
            <div className="cover-container">
                <div className="container py-5 h-100">
                    <div className="row justify-content-center align-items-center h-100">
                        <form>
                            <div className='row justify-content-center align-items-center'>
                                <div className="col-6 form-group mb-3">
                                    <input type="text"
                                        className="form-control"
                                        id="userName"
                                        placeholder="name"
                                        onChange={(e) => this.OnChangeName(e)} />
                                </div>
                                <div className="col-6 form-group mb-3">
                                    <input type="text"
                                        className="form-control"
                                        id="userNickname"
                                        placeholder="nickName"
                                        onChange={(e) => this.OnChangenickname(e)} />
                                </div>
                            </div>
                            <div className="form-group mb-3">
                                <input type="email"
                                    className="form-control"
                                    id="userEmail"
                                    placeholder="email"
                                    onChange={(e) => this.OnChangeEmail(e)} />
                            </div>
                            <div className="form-group mb-3">
                                <input type="password"
                                    className="form-control"
                                    id="userPassword"
                                    placeholder="password"
                                    onChange={(e) => this.OnChangePassword(e)} />
                            </div>
                            <div className="form-group mb-2 col-6">
                                <input type="date"
                                    className="form-control"
                                    id="userDate"
                                    placeholder="birthday"
                                    onChange={(e) => this.OnChangeBirthday(e)} />
                            </div>
                        </form>

                        <button type="submit" className="btn login-btn" onClick={(e) => this.handleSignupClick(e)}>ثبت نام</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Register;