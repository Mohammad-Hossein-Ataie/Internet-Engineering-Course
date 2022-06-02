import React, { Component } from 'react';
import Navbar from '../navbar/Navbar';
import { Link } from 'react-router-dom';
import { DOMAIN } from '../../config/config';

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
        isLoading: true,
        actor: {},
        movies: []
    }

    componentDidMount = () => {
        document.title = "Actor";
        this.getActor();
    }

    getActor = () => {
        const url = DOMAIN + window.location.pathname;
        fetch(url, {
            method: 'get',
            headers: { 'Content-Type': 'application/json' },
        }).then(res => {
            return (res.json())
        }).then(data => {
            this.setState({
                actor: {
                    id: data[0].id,
                    name: data[0].name,
                    birthDate: data[0].birthDate,
                    nationality: data[0].nationality,
                    totalMovies: data[1].length,
                    image: data[0].actorImage
                },
                movies: data[1].map(movie => ({
                    id: movie.id,
                    name: movie.name,
                    image: movie.movieImage,
                })),
                isLoading: false
            })
        });
    }


    render() {
        if (this.state.isLoading) {
            return (<h1>loading</h1>)
        }
        return (
            <>
                <Navbar />

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
                        <span className="box-title mb-2"> فیلم ها</span>
                        <div className="movie-box w-50 m-auto p-4 d-flex flex-column mb-5">
                            <div className="row">
                                {this.state.movies != null && this.state.movies.map(movie => {
                                    return (
                                        <div className="col-md-4 col-12">
                                            <Link to={`/movies/${movie.id}`} target="_blank">
                                                <img className="movie-box-img" src={movie.image} alt={movie.name} />
                                            </Link>
                                        </div>
                                    )
                                })}

                            </div>
                        </div>
                    </div>

                    <div className="col-3">
                        <img className="background-img" src={this.state.actor.image} alt="" />
                    </div>
                </div>
            </>
        );
    }
}

export default Actors;
