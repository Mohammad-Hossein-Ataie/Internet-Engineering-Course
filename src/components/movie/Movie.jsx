import { Box, Rating } from '@mui/material';
import StarIcon from '@mui/icons-material/Star';
import React, { Component } from 'react';
import { FaChevronCircleUp, FaChevronCircleDown } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import Navbar from '../navbar/Navbar';
import { DOMAIN } from '../../config/config';
import { WATCHLIST_ADDED, ERR_WATCHLIST_ADDED } from '../../config/messages';


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
    rate: 4.5,
    totalRate: 0,
    duration: 105,
    ageLimit: 18,
    image: "http://cdn.6nightmovie.click/upload/280/7wzdecuDAYT8-NJacVe3CJe-Qhe8.jpg",
    coverImage: "http://cdn.6nightmovie.click/upload/1920/hTxESmQlgfAoYa7r-2fDvTKWrHyN.jpg"
}

const actors = [
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
            movie: {},
            actors: [],
            newComment: "",
            comments: [],
            commentId: 0,
            userRate: 0
        }
    }

    componentDidMount = () => {
        if (localStorage.getItem("user") != "") {
            document.title = "Movie";
            this.getMovie();
        }
        else {
            window.location.href = '/login';
        }
    }

    getMovie = () => {
        const url = DOMAIN + window.location.pathname;
        fetch(url, {
            method: 'get',
            headers: { 'Content-Type': 'application/json' },
        }).then(res => {
            return (res.json())
        }).then(data => {
            console.log("get m", data)
            this.setState({
                movie: {
                    id: data[0].id,
                    name: data[0].name,
                    summary: data[0].summary,
                    releaseDate: data[0].releaseDate,
                    director: data[0].director,
                    writers: data[0].writers,
                    genres: data[0].genres,
                    cast: data[0].cast,
                    imdbRate: data[0].imdbRate,
                    rate: data[0].rating,
                    totalRate: data[0].totalRate,
                    duration: data[0].duration,
                    ageLimit: data[0].ageLimit,
                    image: data[0].movieImage,
                    coverImage: data[0].movieCoverImage,
                },
                actors: data[1].map(actor => ({
                    id: actor.id,
                    name: actor.name,
                    image: actor.actorImage
                })),
                comments: data[2].map(comment => ({
                    id: comment.commentID,
                    userName: comment.userEmail,
                    text: comment.text,
                    likes: comment.likes,
                    dislikes: comment.dislikes,
                    hasVotedLike: false,
                    hasVotedDislike: false,
                })),
                isLoading: false,
                commentId: [2].length
            })
        });
    }

    addComment = () => {
        let comment = {
            id: this.state.commentId,
            userName: localStorage.getItem("user"),
            text: this.state.newComment,
            likes: 0,
            dislikes: 0,
            hasVotedLike: false,
            hasVotedDislike: false,
        }

        if (this.state.newComment != "") {
            this.setState({
                comments: [...this.state.comments, comment],
                newComment: '',
                commentId: this.state.commentId + 1
            });

            const url = DOMAIN + `/movies/addComment`;
            console.log("addcm", url)
            fetch(url, {
                method: 'post',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    "userEmail": localStorage.getItem("user"),
                    "movieId": this.state.movie.id,
                    "text": comment.text,
                    "likes": comment.likes,
                    "dislikes": comment.dislikes
                })
            });
        }
    }

    handleOnchangeComment = (e) => {
        this.setState({ newComment: e.target.value });
    }

    handleCommentClick = (id, value) => {
        let comments = this.state.comments;
        comments.map((comment, i) => {
            if (comment.id == id) {
                if (value == 1 && !comment.hasVotedLike) {
                    comments[i].likes += 1;
                    comments[i].hasVotedLike = true;
                }
                else if (value == -1 && !comment.hasVotedDislike) {
                    comments[i].dislikes += 1;
                    comments[i].hasVotedDislike = true;
                }
            }
        })
        this.setState({ comments })
    }

    handleRateChange = (value) => {
        this.setState({ userRate: value })
        const url = DOMAIN + '/movies/rate';
        fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "email": localStorage.getItem("user"),
                "movieId": this.state.movie.id,
                "score": value
            })
        });

        this.getMovie()
    }

    addToWatchlist = () => {
        const url = DOMAIN + window.location.pathname + '/' + localStorage.getItem("user");

        fetch(url, {
            method: 'post',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "email": localStorage.getItem("user"),
                "movieId": this.state.movie.id,
            })
        }).then(res => {
            if (res.status == 200) {
                window.alert(WATCHLIST_ADDED);
            }
            else {
                window.alert(ERR_WATCHLIST_ADDED);
            }
        });
    }
    render() {
        console.log("vote comment", this.state.comments)
        if (this.state.isLoading) {
            return (<h1>loading</h1>)
        }
        return (
            <>
                <Navbar />
                <div className="movie-background main-container">
                    <div className="box-background">
                        <img className="background-img" src={this.state.movie.coverImage} alt="movie background" />
                    </div>
                </div>

                <div className="movie-description">
                    <div className="row">
                        <div className="col-3">
                            <div className="rating-box">
                                <div className="imdb">
                                    {this.state.movie.imdbRate}
                                </div>

                                <div className="star-box">
                                    <Box>
                                        <Rating
                                            precision={0.1}
                                            emptyIcon={<StarIcon style={{ opacity: 0.55 }} fontSize="inherit" />}
                                            min={1}
                                            max={10}
                                            value={this.state.userRate}
                                            onChange={e => this.handleRateChange(e.target.value)}
                                        />
                                    </Box>
                                </div>

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
                                            return (<span>{writer},</span>)
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

                                <hr />

                                <div>
                                    {this.state.movie.summary}
                                </div>

                            </div>
                        </div>
                        <div className="col-3" style={{ display: 'flex', flexDirection: 'column' }}>
                            <img className="background-img" src={this.state.movie.image} alt="" />
                            <button className='btn btn-add-watchlist' onClick={this.addToWatchlist}>
                                افزودن به لیست
                            </button>
                        </div>
                    </div>
                </div>

                <div className="gray-container">
                    <span className="container-title">بازیگران</span>
                    <div className="actor-container w-100">
                        {this.state.actors != null && this.state.actors.map(actor => {
                            return (
                                <Link className="actor-item" key={actor.id} to={`/actors/${actor.id}`} target="_blank">
                                    <img className="background-img img-avatar" src={actor.image} alt={actor.name} />
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
                        <hr className="divider" />
                        <textarea rows="2" cols="50" name="comment" form="usrform" onChange={(e) => this.handleOnchangeComment(e)} value={this.state.newComment} />
                        <div>
                            <button className="add-ccomment-btn btn" type="button" onClick={() => this.addComment()}>
                                ثبت
                            </button>
                        </div>
                    </div>
                    {/* <!-- comments  --> */}
                    {this.state.comments != null && this.state.comments.map((comment) => {
                        return (
                            <div key={comment.id} className="comment-container">
                                <span className="comment-title">{comment.userName}</span>
                                <hr className="divider" />
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
                                                <FaChevronCircleUp style={{ color: '#20e856', cursor: 'pointer' }} onClick={() => this.handleCommentClick(comment.id, 1)} />
                                                <span className="text-center">{comment.likes}</span>
                                            </div>
                                            <div className="d-flex flex-column">
                                                <FaChevronCircleDown style={{ color: '#ff2b1c', cursor: 'pointer' }} onClick={() => this.handleCommentClick(comment.id, -1)} />
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