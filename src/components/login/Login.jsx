import React, { Component } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import { DOMAIN } from '../../config/config.js';
import { INVALID_LOGIN } from '../../config/messages';
import { FaGithub } from 'react-icons/fa';

class Login extends Component {
    state = {
        email: '',
        password: null
    }

    componentDidMount() {
        document.title = 'Login';
    }

    handleLoginClick = (e) => {
        const url = DOMAIN + window.location.pathname;

        e.preventDefault();
        fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "email": this.state.email,
                "password": this.state.password,
            })
        }).then(res => {
            if (res.status == 200) {
                localStorage.setItem('user', this.state.email);
                window.location.href = "/";
            }
            else {
                window.alert(INVALID_LOGIN);
            }
        });
    }

    OnChangeEmail = (e) => {
        this.setState({ email: e.target.value });
    }

    OnChangePassword = (e) => {
        this.setState({ password: e.target.value });
    }

    handleGithubLogin = () => {
        window.location.href = 'https://github.com/login/oauth/authorize?client_id=ba82189574fb38061422&scope=user';
    }

    render() {
        return (
            <div className="cover-container">
                <div className="form-container">
                    <form>
                        <div className="form-group mb-5">
                            <input type="email"
                                className="form-control"
                                id="userEmail"
                                aria-describedby="emailHelp"
                                placeholder="ایمیل"
                                onChange={(e) => this.OnChangeEmail(e)} />
                        </div>
                        <div className="form-group mb-1">
                            <input type="password"
                                className="form-control"
                                id="userPassword"
                                placeholder="رمز عبور"
                                onChange={(e) => this.OnChangePassword(e)} />
                        </div>
                        <div className="form-check mb-4">
                            <input type="checkbox"
                                className="form-check-input"
                                id="exampleCheck1" />
                            <label className="form-check-label" for="exampleCheck1">
                                مرا بخاطر بسپار
                            </label>
                        </div>

                        <button type="submit" className="btn login-btn" onClick={(e) => this.handleLoginClick(e)}>ورود</button>
                    </form>

                    <div className='github-link'>
                        <div className='text-light' onClick={() => this.handleGithubLogin()}>
                            <FaGithub className='github-icon' />
                            <span>با گیت هاب وارد شوید</span>
                        </div>
                    </div>
                </div>

                <div className="register-cover">
                    <p className="h6">هنوز ثبت نام نکرده اید؟</p>
                    <a className="text-white" href="/signup">ثبت نام</a>
                </div>
            </div>
        );
    }
}

export default Login;