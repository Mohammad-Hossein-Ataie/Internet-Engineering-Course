import React, { Component } from 'react';
import Navbar from '../navbar/Navbar';
import {Link} from 'react-router-dom';

    const actor = {
        id: 45,
        name: "Tim Robbins",
        birthDate: "October 16, 1958",
        nationality: "USA",
        totalMovies: 4,
        image: "http://cdn.6nightmovie.click/upload/people/edc26282ecf19e509a540e81f0ed5cf2.jpg"
    }

    const movies = [
        {
            id: 1,
            name: '1',
            image: "http://cdn.6nightmovie.click/upload/280/tZk8L7twLD-OAW0EU0aQGN40BD6T.jpg"
        },
        {
            id: 2,
            name: '1',
            image: "http://cdn.6nightmovie.click/upload/280/VOyJcP6nivTxTMd4DOibbERBdSJe.jpg"
        },
        {
            id: 3,
            name: '1',
            image: "http://cdn.6nightmovie.click/upload/280/eYb12gj0khYlhRYRZrIW6ugcZUP6.jpg"
        }
    ]

class Actors extends Component {
    state = { 
        actor : actor,
        movies: movies
    } 

    componentDidMount = () => {
      document.title = "Actor";
    }
    
    render() { 
        return (
        <>
            <Navbar/>

            <div className="row text-white main-container">
                <div className="col-9">
                    <span className="box-title">مشخصات بازیگر</span>
                    <div className="actor-inf">
                        <div>
                            <span> نام: </span>
                            <span>{this.state.actor.name}</span>
                        </div>
                        <div>
                            <span> تاریخ تولد: </span>
                            <span>{this.state.actor.birthDate}</span>
                        </div>
                        <div>
                            <span> ملیت: </span>
                            <span>{this.state.actor.nationality}</span>
                        </div>
                        <div>
                            <span> تعداد فیلم ها: </span>
                            <span>{this.state.actor.totalMovies}</span>
                        </div>
                    </div>
                    <span className="box-title"> فیلم ها</span>
                    <div className="movie-box">
                        <div className="row">

                            {this.state.movies != null && this.state.movies.map(movie => {
                                return(
                                    <div key={movie.id} className="col-md-4 col-12">
                                        <Link to={`/movies/${movie.id}`} target="_blank">
                                            <img className="movie-box-img" src={movie.image} alt={movie.name}/>
                                        </Link>
                                    </div>
                                )
                            })}  
                                                      
                        </div>
                    </div>
                </div>

                <div className="col-3">
                    <img className="background-img" src={this.state.actor.image} alt=""/>
                </div>
            </div>
        </>
        );
    }
}
 
export default Actors;
