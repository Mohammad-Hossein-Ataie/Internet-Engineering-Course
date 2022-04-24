import React, { Component } from 'react';

class Register extends Component {
    state = {  } 

    render() { 
        return (
            <div className="cover-container">
                <div className="container py-5 h-100">
                    <div className="row justify-content-center align-items-center h-100">
                    <div className="col-12 col-lg-9 col-xl-7">
                        <div className="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div className="card-body p-4 p-md-5">
                            <form>        
                            <div className="row">
                                    <div className="col-12 mb-4">
                                    <div className="form-outline">
                                        <input type="text" id="firstName" className="form-control form-control-lg" placeholder="نام"/>
                                    </div>
                    
                                    </div>
                                    <div className="col-12 mb-4">
                    
                                        <div className="form-outline datepicker w-100">
                                        <input
                                            type="text"
                                            className="form-control form-control-lg"
                                            id="birthdayDate"
                                            placeholder="تاریخ تولد"
                                        />
                                        </div>
                    
                                    </div>

                                    <div className="col-12 mb-4 pb-2">
                    
                                        <div className="form-outline">
                                        <input type="email" id="emailAddress" className="form-control form-control-lg" placeholder="ایمیل"/>
                                        </div>
                    
                                    </div>
                            </div>
            
                            <div className="mt-4 pt-2">
                                <input className="btn login-btn btn-lg" type="submit" value="ثبت نام"/>
                            </div>
                            </form>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        );
    }
}
 
export default Register;