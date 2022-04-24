import React, { Component } from 'react';
import Navbar from '../navbar/Navbar';
class Movies extends Component {
    state = {  } 
    componentDidMount = () => {
    }
    
    render() { 
        return (
            <>
                {/* <Navbar/> */}
                <div className="container mt-5">
                
                    <div className="row text-center d-flex justify-content-start align-items-center">
                        <div className="col-lg-2 col-12">
                            <div className="card sort-box">
                                <div className="card-title">رتبه بندی بر اساس:</div>
                                <div className="card-body sort-box-body">
                                <p className="card-text">تاریخ</p>
                                <p className="card-text">امتیاز imdb</p>
                            </div>
                        </div>
                    </div>

                    <div className="col-lg-10 col-12">
                        <div className="row m-5">

                            <div className="col-md-4 col-lg-3 col-12 mt-4">
                                <div className="row no-gutters align-items-center">
                                    <img className="movie-img" src="./../../assets/images/movies/batman.jpg" alt=""/>
                                </div>
                            </div> 

                        </div>
                    </div>
                </div>

                </div>
            </>
            
        );
    }
}
 
export default Movies;