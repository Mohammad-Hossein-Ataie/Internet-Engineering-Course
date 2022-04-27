import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import Navbar from '../navbar/Navbar';
import NavbarHome from '../navbar/NavbarHome';
import config from './../../config/config';


const movies = [
    {
        id: 1,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/2o0UIXWpvEUiFfEucv_j5fmMbyhF.jpg",
    },
    {
        id: 2,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/6OKPZ4QWImBxn5nFO2hipn7-BmG-.jpg",
    },
    {
        id: 3,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/xD-QctJmtxhAwkiYKsrOPJnwAmEK.jpg",
    },
    {
        id: 4,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/XH7PpDCH8us-5EMmGDsd1angxcY3.jpg",
    },
    {
        id: 5,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/90NkzGHXRR99YULOCErfMdGdzoyt.jpg",
    },
    {
        id: 6,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/cmc4j956PDDPrgnyNSaVMG4UxnUi.jpg",
    },
    {
        id: 7,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/gmyAxHcEB6S2PxguijmJwo_ZyZjE.jpg",
    },
    {
        id: 8,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/pO0G_ChLv031i-R-DLwmqEf7KEL-.jpg",
    },
    {
        id: 9,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/Xq5mSnknAscCCdnT3sarCAH8-5Jh.jpg",
    },
    {
        id: 10,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/OTenZDM6XJ0ZddTcl3DFFWqttgz9.jpg",
    },
    {
        id: 11,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/Nt2At-X0bzO5w5cuD0GScFoGlg4c.jpg",
    },
    {
        id: 12,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/280/vtUc_4VMHuFYagBaj6ur17nj4Rpw.jpg",
    }
]
class Movies extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading : true,
            movies : movies,
        }
        this.getMovies = this.getMovies.bind(this);
    }

    componentDidMount = () => {
        document.title = "Home";
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
                {/* <NavbarHome/> */}
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

                            {this.state.movies != null && this.state.movies.map((movie) => {
                                return(
                                    <div key={movie.id} className="col-md-4 col-lg-3 col-12 mt-4">
                                        <Link className="row no-gutters align-items-center" 
                                              to={`/movies/${movie.id}`} 
                                              target="_blank">
                                            <img className="movie-img" src={movie.image} alt="poster"/>
                                        </Link>
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