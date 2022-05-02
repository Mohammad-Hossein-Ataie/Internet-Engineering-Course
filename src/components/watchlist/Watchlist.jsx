import React, { Component } from 'react'
import Navbar from '../navbar/Navbar';
import { RiDeleteBin6Fill } from 'react-icons/ri';
import { Link } from 'react-router-dom';
import { DOMAIN } from '../../config/config';
import { EMPTY_WATCHLIST } from '../../config/messages';


const watchlists = [
    {
        id: 1,
        name: "The Shawshank Redemption ( 1994 )",
        director: "Frank Darabont",
        releaseDate: "1994/10/13",
        genres: [
            "جنایی",
            "درام"
        ],
        imdbRate: 9.3,
        duration: 142,
        rate: 0,
        image: "http://cdn.6nightmovie.click/upload/280/6Mn3SsAYF9z48yqIr3eXSvVfCXVa.jpg",
    },
    {
        id: 2,
        name: "The Godfather ( 1972 )",
        releaseDate: "1972/03/23",
        director: "Francis Ford Coppola",
        genres: [
            "جنایی",
            "درام"
        ],
        imdbRate: 9.2,
        duration: 175,
        rate: 0,
        image: "http://cdn.6nightmovie.click/upload/280/l-RJD3-whodsVu72OeLIGN-QXSa9.jpg",

    }
]

const movies = [
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
class Watchlist extends Component {
    state = {
        isLoading: true,
        watchlists: [],
        movies: movies,
    }

    componentDidMount = () => {
        if (localStorage.getItem("user") != "") {
            document.title = "Watchlist";
            this.getWatchlist();
        }
        else {
            window.location.href = "/login";
        }

    }

    getWatchlist = () => {
        const url = DOMAIN + window.location.pathname + '/' + localStorage.getItem('user');
        fetch(url, {
            method: 'get',
            headers: { 'Content-Type': 'application/json' },
        }).then(res => {
            return res.json();
        }).then(data => {

            console.log("data", data);
            if (data.length == 0) {
                window.alert(EMPTY_WATCHLIST);
                this.setState({ isLoading: false })
            }
            else {
                this.setState({
                    watchlists: data[0].map(item => ({
                        id: item.id,
                        name: item.name,
                        director: item.director,
                        releaseDate: item.releaseDate,
                        genres: item.genres,
                        imdbRate: item.imdbRate,
                        duration: item.duration,
                        rate: item.rating,
                        image: item.movieImage,
                    })),
                    isLoading: false
                })
            }

        })
    }

    handleDeleteMovie = (id) => {
        let watchlists = this.state.watchlists.filter(item => item.id != id);
        this.setState({ watchlists });
        const url = DOMAIN + `${window.location.pathname}/${id}`;
        console.log("url", url);
        fetch(url, {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' }
        }).then(res => {
            console.log("res", res);
        });
        //this.getWatchlist();
    }

    render() {
        if (this.state.isLoading) {
            return (<h1>loading</h1>)
        }
        return (
            <>
                <Navbar />

                <div className="main-container">
                    <div className="container p-5 mb-5">
                        {this.state.watchlists != null && this.state.watchlists.map(item => {
                            return (
                                <div key={item.id} className="list-container mb-5">
                                    <div className="row">
                                        <div className="col-9">
                                            <div className="list-title">
                                                <button className="remove-btn">
                                                    <RiDeleteBin6Fill className="iconify remove-icon" onClick={() => this.handleDeleteMovie(item.id)} />
                                                </button>
                                                <p className="text-white movie-title">
                                                    {item.name}
                                                </p>
                                            </div>

                                            <div className="row text-white m-1">
                                                <div className="col-6">
                                                    <span className="h6">کارگردان: </span>
                                                    <span className="description">{item.director}</span>
                                                </div>
                                                <div className="col-6">
                                                </div>
                                                <div className="col-6">
                                                    <span className="h6">ژانر: </span>
                                                    {item.genres.map(genre => {
                                                        return (<span className="description m-1">{genre},</span>)
                                                    })}

                                                </div>
                                                <div className="col-6">
                                                    <span className="h6">امتیازimdb</span>
                                                    <span className="description">{item.imdbRate}</span>
                                                </div>
                                                <div className="col-6">
                                                    <span className="h6">تاریخ انتشار: </span>
                                                    <span className="description">{item.releaseDate}</span>
                                                </div>
                                                <div className="col-6">
                                                </div>
                                                <div className="col-6">
                                                    <span className="h6">مدت زمان: </span>
                                                    <span className="description">{item.duration} دقیقه</span>
                                                </div>
                                                <div className="col-6">
                                                    <span className="h6">امتیاز کاربران: </span>
                                                    <span className="description"> {item.rate}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div className="col-3">
                                            <img className="background-img movie-img" src={item.image} alt="" />
                                        </div>
                                    </div>
                                </div>
                            )
                        })}
                    </div>

                    <div className="movie-box w-50 m-auto p-4 d-flex flex-column mb-5">
                        <span className="h6">فیلم های پیشنهادی</span>
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
            </>);
    }
}

export default Watchlist;