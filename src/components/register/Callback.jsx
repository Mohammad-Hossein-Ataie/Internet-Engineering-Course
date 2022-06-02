
import React, { Component } from 'react';
import { Redirect } from "react-router-dom";
import { DOMAIN } from '../../config/config';

class Callback extends Component {

    state = {
        client_id: '',
        client_secret: '',
        code: '',
        redirect_uri: ''
    }


    componentDidMount() {
        // const code = window.location.href.split('?code=')[1];
        this.setState({
            client_id: 'ba82189574fb38061422',
            client_secret: 'f6c65b31837082c1f54490f6785d4fdcd05c5d34',
            code: window.location.href.split('?code=')[1],
            redirect_uri: 'http://localhost:3000/'
        });

    }

    componentDidUpdate() {

        const token_url = `https://github.com/login/oauth/access_token?client_id=${this.state.client_id}&client_secret=${this.state.client_secret}&code=${this.state.code}&redirect_uri=${this.state.redirect_uri}`;
        const backend_url = DOMAIN + '/callback/' + this.state.code;
        fetch(backend_url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: {}
        }).then(res => {
            return res.json()
        }).then(data => {
            if (data.token != null) {
                localStorage.setItem('user-token', data.token);
                localStorage.setItem('user', data.email);
                window.location = '/';
            }
        });

    }

    state = {}
    render() {


        return (
            <h1 className='text-light'>callback</h1>
        );
    }
}

export default Callback;
