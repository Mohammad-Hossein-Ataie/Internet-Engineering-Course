import React, { Component } from 'react';
import { FaChevronCircleUp, FaChevronCircleDown } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import Navbar from '../navbar/Navbar';

const movie = {
    id: 67,
    name: "Spider-Man: Into the Spider-Verse ( 2018 )",
    summary: "در این فیلم انیمیشنی با شخصیت مایلز مورالس بیشتر آشنا می‌شویم. نوجوانی که به طور اتفاقی با مرد عنکبوتی دیدار می‎کند و صاحب قدرت‎هایی می‎شود که…",
    releaseDate: "2014/11/06",
    director: "Bob Persichetti",
    writers: [
        "James Wan",
        "Phil Lord",
        "Andrew Stanton"
    ],
    genres: [
        "انیمیشن",
        "اکشن",
        "ماجراجویی"
    ],
    cast: [
        3632,
        313,
        74
    ],
    imdbRate: 8.4,
    rate: 0,
    totalRate: 0,
    duration: 105,
    ageLimit: 18,
    image: "http://cdn.6nightmovie.click/upload/280/7wzdecuDAYT8-NJacVe3CJe-Qhe8.jpg",
    coverImage: "http://cdn.6nightmovie.click/upload/1920/hTxESmQlgfAoYa7r-2fDvTKWrHyN.jpg"
}

const actors =[
    {
        id: 1,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/edc26282ecf19e509a540e81f0ed5cf2.jpg"
    },
    {
        id: 2,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/2724aae581458af12384cf8d12bd408f.jpg"
    },
    {
        id: 3,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/f3c3870624cb5fb14e51ccd58d385ece.jpg"
    },
    {
        id: 4,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/39bcd2622ae503d65eaa23af3e6fce8e.jpg"
    },
    {
        id: 5,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/3ff24b40ca229ec2d1ed8e09b5b0c81c.jpg"
    },
    {
        id: 6,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/98b097315eeb0acdc7ac30ea656ec943.jpg"
    },
    {
        id: 7,
        name: "1",
        image: "http://cdn.6nightmovie.click/upload/people/19a70b4431888adc36be0824c7bf8d76.jpg"
    }
]
class Movie extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            movie: movie,
            actors: actors,
            newComment: "",
            comments: [],
            commentId : 1
        }
    }
 
    componentDidMount = () => {
        this.getMovie();
    }

    getMovie = async () => {
        const response = await fetch('http://138.197.181.131:5000/api/v2/movies');
        const data = await response.json();
        this.setState({
            movie: data,
            loading: false
        })
    }

    addComment = () => {
        let comment = {
            id : this.state.commentId,
            userName: "kimia",
            text: this.state.newComment,
            likes: 0,
            dislikes: 0
        }

        this.setState({
            comments: [...this.state.comments, comment],
            newComment: '',
            commentId: this.state.commentId+1
        })
    }

    handleOnchangeComment = (e) => {
        this.setState({newComment: e.target.value});
    }

    handleCommentClick = (id, value) => {
        let comments = this.state.comments;
        comments.map((comment, i) => {
            if(comment.id == id){
                if(value == 1) {
                    comments[i].likes += 1;
                }
                else {
                    comments[i].dislikes -= 1;
                }
            }
        })
        this.setState({comments})
    }

    render() { 
        return (
            <>
                <Navbar/>
                <div className="movie-background main-container">
                    <div className="box-background">
                        <img className="background-img" src={this.state.movie.coverImage} alt="movie background"/>
                    </div>
                </div>

                <div className="movie-description">
                    <div className="row">
                        <div className="col-3">
                            <div className="rating-box">
                                <div className="imdb">
                                    {this.state.movie.imdbRate}
                                </div>

                                {/* <div className="star-box">
                                    <span role="button" className="iconify" data-icon="el:star" style="color: gray;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: gray;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: gray;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: gray;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                    <span role="button" className="iconify" data-icon="el:star" style="color: yellow;" data-width="30" data-height="30"></span>
                                </div> */}

                                <div className="user-rating">
                                    <div className="d-flex flex-column text-center">
                                        <span className="h5">امتیاز کاربران</span>
                                        <span>(
                                            <span>{this.state.movie.totalRate}</span>
                                    رای)</span>
                                    </div>
                                    <div>
                                        <span className="h3">{this.state.movie.rate}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div className="col-6">
                        <div className="movie-inf">
                            <span className="movie-title">
                                 {this.state.movie.name}
                            </span>

                            <div>
                                <span>کارگردان: </span>
                                <span>{this.state.movie.director}</span>
                            </div>
                
                            <div>
                                <span> نویسنده: </span>
                                {
                                    this.state.movie.writers.map(writer => {
                                        return(<span>{writer},</span>)
                                    })
                                }
                            </div>
                
                            <div>
                                <span>مدت زمان: </span>
                                <span>{this.state.movie.duration}دقیقه</span>
                            </div>
                
                            <div className="movie-date">
                                <span>تاریخ انتشار: </span>
                                <span>{this.state.movie.releaseDate}</span>
                            </div>
                
                            <hr/>
                
                            <div>
                                {this.state.movie.summary}
                            </div>
                
                        </div>
                    </div>
                    <div className="col-3">
                        <img className="background-img" src={this.state.movie.image} alt=""/>
                    </div>
                    </div>
                </div>

                <div className="gray-container">
                    <span className="container-title">بازیگران</span>
                    <div className="actor-container w-100">
                        {this.state.actors != null && this.state.actors.map(actor => {
                            return(
                                <Link className="actor-item" key={actor.id} to={`/actors`} target="_blank">
                                    <img className="background-img img-avatar" src={actor.image} alt={actor.name}/>
                                </Link>
                            )
                        })}
                    </div>    
                </div>

                <div className="gray-container">
                    <span className="container-title">دیدگاه ها</span>
                        {/* add comment*/}
                        <div className="comment-container">
                            <span className="comment-title">دیدگاه خود را اضافه کنید:</span>
                            <hr className="divider"/>
                            <textarea rows="2" cols="50" name="comment" form="usrform" onChange={(e) => this.handleOnchangeComment(e)} value={this.state.newComment}/>
                            <div>
                                <button className="add-ccomment-btn btn" type="button" onClick={() => this.addComment()}>
                                    ثبت
                                </button>
                        </div>
             </div>
        {/* <!-- comments  --> */}
        {this.state.comments != null && this.state.comments.map((comment) => {
            return(
                <div key={comment.id} className="comment-container">
                    <span className="comment-title">{comment.userName}</span>
                    <hr className="divider"/>
                    <div className="row">
                        <div className="col-12 col-md-10">
                            <span className="comment-text">
                                {comment.text}
                            </span>
                        </div>
                        {/* <!-- like dislike --> */}
                        <div className="col-12 col-md-2">
                            <div className="d-flex justify-content-between">
                                <div className="d-flex flex-column">
                                    <FaChevronCircleUp style={{color: '#20e856', cursor: 'pointer'}} onClick={()=>this.handleCommentClick(comment.id, 1)}/>
                                    <span className="text-center">{comment.likes}</span>
                                </div>
                                <div className="d-flex flex-column">
                                    <FaChevronCircleDown style={{color: '#ff2b1c', cursor: 'pointer'}} onClick={()=>this.handleCommentClick(comment.id, -1)}/>
                                    <span className="text-center">{comment.dislikes}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            )
        })}
            </div>
        </>
        );
    }
}
 
export default Movie;