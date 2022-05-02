import React, { Component } from 'react';

class Logout extends Component {
    state = {
    }

    componentDidMount() {
        console.log("log")
    }

    render() {
        return (
            <>
                <h1 className='text-white'>logout</h1>
            </>
        );
    }

}

export default Logout;