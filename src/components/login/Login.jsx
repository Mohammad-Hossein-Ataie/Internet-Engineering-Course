import React, { Component } from 'react';

class Login extends Component {
    state = { 
        email: '',
        password: null
    } 

    handleLoginClick = () => {
        sessionStorage.setItem("userMail", this.state.email);
    }

    OnChangeEmail = (e) => {
        this.setState({email: e.target.value});
    }

    OnChangePassword = (e) => {
        this.setState({password: e.target.value});
    }

    render() { 
        console.log(sessionStorage.getItem("userMail"));
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
                                   onChange={(e) => this.OnChangeEmail(e)}/>
                            </div>
                            <div className="form-group mb-1">
                            <input type="password" 
                                   className="form-control" 
                                   id="userPassword" 
                                   placeholder="رمز عبور"
                                   onChange={(e) => this.OnChangePassword(e)}/>
                        </div>
                        <div className="form-check mb-4">
                            <input type="checkbox" 
                                   className="form-check-input" 
                                   id="exampleCheck1"/>
                            <label className="form-check-label" for="exampleCheck1">
                                مرا بخاطر بسپار
                            </label>
                        </div>
                        <button type="submit" className="btn login-btn" onClick={() => this.handleLoginClick()}>ورود</button>
                    </form>
                </div>

                <div className="register-cover">
                    <p className="h6">هنوز ثبت نام نکرده اید؟</p>
                    <a className="text-white" href="signup.html">ثبت نام</a>
                </div>
            </div>
        );
    }
}
 
export default Login;