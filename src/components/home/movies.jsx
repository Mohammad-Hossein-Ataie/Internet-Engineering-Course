import React, { Component } from 'react';
import Navbar from '../navbar/Navbar';
import config from './../../config/config';

class Movies extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading : true,
            movies : [],
        }
        this.getMovies = this.getMovies.bind(this);
    }

    componentDidMount = () => {
        this.getMovies();
    }

    async getMovies(){
        // const response = await fetch(config.MOVIES_URL);
        const response = await fetch('http://138.197.181.131:5000/api/v2/movies');
        const data = await response.json();
        this.setState({
            movies: data,
            isLoading: false
        })
        console.log("🚀 ~ file: Movies.jsx ~ line 15 ~ Movies ~ getMovies ~ data", data)
    }
    
    render() { 
        return (
            <>
                {/* <Navbar/> Poster src={movie.Poster}*/}
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

                            {!this.state.isLoading && this.state.movies.map((movie) => {
                                return(
                                    <div key={movie.id} className="col-md-4 col-lg-3 col-12 mt-4">
                                        <div className="row no-gutters align-items-center">
                                            <img className="movie-img" src={movie.image} alt="poster"/>
                                        </div>
                                    </div>
                                )
                            })}
                        </div>
                    </div>
                </div>

                </div>
            </>
            
        );
    }
}
 
export default Movies;