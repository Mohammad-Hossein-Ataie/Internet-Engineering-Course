import { Link } from 'react-router-dom';
import React, { Component } from 'react';
import { DOMAIN } from '../../config/config';
import { FaGithub } from 'react-icons/fa';

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
        if (this.state.email.includes('@', '.')) {
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
                if (res.status == 200) {
                    localStorage.setItem('user', this.state.email);
                    window.location.href = "/";
                }
            });
        }
        else {
            window.alert('فرمت ایمیل اشتباه است')
        }

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

    handleGithubLogin = () => {
        window.location.href = 'https://github.com/login/oauth/authorize?client_id=ba82189574fb38061422&scope=user';
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

                        <div className='col-4 github-link'>
                            <div className='text-light' onClick={() => this.handleGithubLogin()}>
                                <FaGithub className='github-icon' />
                                <span>با گیت هاب وارد شوید</span>
                            </div>
                        </div>

                        <button type="submit" className="btn login-btn" onClick={(e) => this.handleSignupClick(e)}>ثبت نام</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Register;