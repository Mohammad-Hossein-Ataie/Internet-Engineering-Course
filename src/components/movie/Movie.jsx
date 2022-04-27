import React, { Component } from 'react';
import { FaChevronCircleUp, FaChevronCircleDown } from 'react-icons/fa';

class Movie extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: true,
            movie: null,
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
        // console.log("🚀 ~ file: Movies.jsx ~ line 15 ~ Movies ~ getMovies ~ data", data)
    }

    addComment = () => {
    console.log("🚀 addComment")
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
                value == 1 ? comments[i].likes += value : comments[i].dislike += value
            }
        })
        this.setState({comments})
    }
    // http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png

    render() { 
        console.log("🚀 ~ file: Movie.jsx ~ line 53 ~ Movie ~ render ~ render", this.state.comments)
        return (
            <>
                <div className="movie-background main-container">
                    <div className="box-background">
                        <img className="background-img" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="movie background"/>
                    </div>
                </div>

                <div className="movie-description">
                    <div className="row">
                        <div className="col-3">
                            <div className="rating-box">
                                <div className="imdb">
                                    8.8
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
                                            <span>23</span>
                                    رای)</span>
                                    </div>
                                    <div>
                                        <span className="h3">8.3</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <div className="col-6">
                        <div className="movie-inf">
                            <span className="movie-title">
                                Spider-man: No Way Home
                            </span>

                            <div>
                                <span>کارگردان: </span>
                                <span>Stan Lee, Steve Ditko</span>
                            </div>
                
                            <div>
                                <span>نویسنده: </span>
                                <span>John Wats</span>
                            </div>
                
                            <div>
                                <span>مدت زمان: </span>
                                <span>145دقیقه</span>
                            </div>
                
                            <div className="movie-date">
                                <span>تاریخ انتشار: </span>
                                <span>2021/12/17</span>
                            </div>
                
                            <hr/>
                
                            <div>
                                پس از افشای هویت مرد عنکبوتی توسط میستریو, شهرت و زندگی پارکر زیر و رو می وشد. او از دکتر استرنج میخواهد تا یا جادو به بازگرداندن هویت مخفی اش کمک کند, اما این کار عواقب غیر منتظره ای دارد که باعث می شود پارکر معنای واقعی مرد عنکبوتی بودن را دریابد...
                            </div>
                
                        </div>
                    </div>
                    <div className="col-3">
                        <img className="background-img" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt=""/>
                    </div>
                    </div>
                </div>

                <div className="gray-container">
                    <span className="container-title">بازیگران</span>
                    <div className="actor-container w-100">
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                                <a className="actor-item" href="#">
                                    <img className="background-img img-avatar" src="http://commondatastorage.googleapis.com/codeskulptor-demos/riceracer_assets/img/car_3.png" alt="actor"/>
                                </a>
                    </div>    
                </div>

                <div className="gray-container">
                    <span className="container-title">دیدگاه ها</span>
                        {/* add comment     */}
                        <div className="comment-container">
                            <span className="comment-title">دیدگاه خود را اضافه کنید:</span>
                            <hr className="divider"/>
                            <textarea rows="2" cols="50" name="comment" form="usrform" onChange={(e) => this.handleOnchangeComment(e)} value={this.state.newComment}/>
                            <div>
                                <button className="add-ccomment-btn btn" type="button" onClick={this.addComment}>
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
                                    <FaChevronCircleUp style={{color: '#20e856', cursor: 'pointer'}} onClick={this.handleCommentClick(comment.id, 1)}/>
                                    <span className="text-center">{comment.likes}</span>
                                </div>
                                <div className="d-flex flex-column">
                                    <FaChevronCircleDown style={{color: '#ff2b1c', cursor: 'pointer'}} onClick={this.handleCommentClick(comment.id, -1)}/>
                                    <span className="text-center">{comment.dislikes}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            )
        })}
        {/* <!-- 1  --> */}
            {/* <div className="comment-container">
                <span className="comment-title">علی</span>
                <hr className="divider"/>
                <div className="row">
                    <div className="col-12 col-md-10">
                        <span className="comment-text">
                            فیلم تاثیرگذاری بود
                        </span>
                    </div>
                    <div className="col-12 col-md-2">
                        <div className="d-flex justify-content-between">
                            <div className="d-flex flex-column">
                                <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-up-fill" style={{color: '#20e856',dataWidth: "25", dataHeight:"25"}}></span>
                                <span className="text-center">12</span>
                            </div>
                            <div className="d-flex flex-column">
                                <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-down-fill" style={{color: '#ff2b1c',dataWidth: "25", dataHeight:"25"}}></span>
                                <span className="text-center">5</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <div className="comment-container">
            <span className="comment-title">حسن</span>
            <hr className="divider"/>
            <div className="row">
                <div className="col-12 col-md-10">
                    <span className="comment-text">
                        زیبا
                    </span>
                </div>
                <div className="col-12 col-md-2">
                    <div className="d-flex justify-content-between">
                        <div className="d-flex flex-column">
                            <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-up-fill" style={{color: '#20e856',dataWidth: "25", dataHeight:"25"}}></span>
                            <span className="text-center">5</span>
                        </div>
                        <div className="d-flex flex-column">
                            <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-down-fill" style={{color: '#ff2b1c',dataWidth: "25", dataHeight:"25"}}></span>
                            <span className="text-center">12</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <div className="comment-container">
                <span className="comment-title">مصطفی</span>
                <hr className="divider"/>
                    <div className="row">
                        <div className="col-12 col-md-10">
                            <span className="comment-text">
                                نپسندیدم
                            </span>
                        </div>
                        <div className="col-12 col-md-2">
                            <div className="d-flex justify-content-between">
                                <div className="d-flex flex-column">
                                    <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-up-fill" style={{color: '#20e856',dataWidth: "25", dataHeight:"25"}}></span>
                                    <span className="text-center">1</span>
                                </div>
                                <div className="d-flex flex-column">
                                    <span className="iconify" role="button" data-icon="akar-icons:circle-chevron-down-fill" style={{color: '#ff2b1c',dataWidth: "25", dataHeight:"25"}}></span>
                                    <span className="text-center">13</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> */}
            </div>
        </>
        );
    }
}
 
export default Movie;