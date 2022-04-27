import React, { Component } from 'react';
import Navbar from '../navbar/Navbar';


    const actor = {
        id: 45,
        name: "Tim Robbins",
        birthDate: "October 16, 1958",
        nationality: "USA",
        totalMovies: 4,
        image: "http://cdn.6nightmovie.click/upload/people/edc26282ecf19e509a540e81f0ed5cf2.jpg"
    }

class Actors extends Component {
    state = { 
        actor : actor
    } 

    componentDidMount = () => {
      document.title = "Actor"
    }
    
    render() { 
    console.log("🚀 ~ file: Actors.jsx ~ line 24 ~ Actors ~ render ~ render", this.state)

        return (
        <>
            <Navbar/>

            <div class="row text-white main-container">
                <div class="col-9">
                    <span class="box-title">مشخصات بازیگر</span>
                    <div class="actor-inf">
                        <div>
                            <span>نام:</span>
                            <span>{this.state.actor.name}</span>
                        </div>
                        <div>
                            <span>تاریخ تولد:</span>
                            <span>{this.state.actor.birthDate}</span>
                        </div>
                        <div>
                            <span>ملیت:</span>
                            <span>{this.state.actor.nationality}</span>
                        </div>
                        <div>
                            <span>تعداد فیلم ها:</span>
                            <span>{this.state.actor.totalMovies}</span>
                        </div>
                    </div>
                    <span class="box-title"> فیلم ها</span>
                    {/* <div class="movie-box">
                        <div class="row">

                            <div class="col-md-4 col-12">
                                <a href="#">
                                    <img class="movie-box-img" src="../../assets/images/movies/spiderman.jpg" alt="">
                                </a>
                            </div>
                            <div class="col-md-4 col-12">
                                <a href="#">
                                    <img class="movie-box-img" src="../../assets/images/movies/spiderman.jpg" alt="">
                                </a>
                            </div>
                            <div class="col-md-4 col-12">
                                <a href="#">
                                    <img class="movie-box-img" src="../../assets/images/movies/spiderman.jpg" alt="">
                                </a>
                            </div>
                            
                        </div>
                    </div> */}
                </div>

                <div class="col-3">
                    <img class="background-img" src={this.state.actor.image} alt=""/>
                </div>
            </div>
        </>
        );
    }
}
 
export default Actors;
