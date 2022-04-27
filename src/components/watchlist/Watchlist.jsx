import React, { Component } from 'react'
import Navbar from '../navbar/Navbar';
import { RiDeleteBin6Fill } from 'react-icons/ri';


const watchlists = [
        {
            id : 1,
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
class Watchlist extends Component {
    state = { 
        watchlists : watchlists
     } 

    componentDidMount = () => {
        document.title = "Watchlist";
      
    }

    handleDeleteMovie = (id) => {
        let watchlists = this.state.watchlists.filter(item => item.id != id);
        this.setState({watchlists});
    }
    
    render() { 
        return (
        <>
            <Navbar/>

            <div className="main-container">
                <div className="container p-5 mb-5">
                    {this.state.watchlists !=null && this.state.watchlists.map(item => {
                        return(
                            <div key={item.id} className="list-container mb-5">
                                <div className="row">
                                    <div className="col-9">
                                            <div className="list-title">
                                                <button className="remove-btn">
                                                    <RiDeleteBin6Fill className="iconify remove-icon" onClick={() => this.handleDeleteMovie(item.id)}/>
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
                                                        return(<span className="description m-1">{genre},</span>)
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
                                        <img className="background-img movie-img" src={item.image} alt=""/>
                                    </div>
                                </div>
                            </div> 
                        )
                    })}           
                </div>

                {/* <div className="movie-box w-50 m-auto p-4 d-flex flex-column mb-5">
                    <span className="h6">فیلم های پیشنهادی</span>
                    <div className="row">
                        <div className="col-md-4 col-12">
                            <a href="#">
                                <img className="movie-box-img" src="../../assets/images/movies/conjuring.jpg" alt="">
                            </a>
                        </div>
                        <div className="col-md-4 col-12">
                            <a href="#">
                                <img className="movie-box-img" src="../../assets/images/movies/conjuring.jpg" alt="">
                            </a>
                        </div>
                        <div className="col-md-4 col-12">
                            <a href="#">
                                <img className="movie-box-img" src="../../assets/images/movies/inception.jpg" alt="">
                            </a>
                        </div>
                        
                    </div>
                </div> */}
        </div>
        </>);
    }
}
 
export default Watchlist;