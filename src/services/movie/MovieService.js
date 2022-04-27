import {MOVIES_URL, MOVIE_URL} from '../../config/config';

export default function MovieService() {
    async function getMoviesService(){
        const response = await fetch(MOVIES_URL);
        const data = await response.json();
        return data;
    }

    async function getMovieByIdService(data) {
        const response = await fetch(MOVIES_URL+data.id);
        const data = await response.json();
        return data;
    }

    async function getMovieByGenreService(data) {
        const response = await fetch(MOVIES_URL+data.genre);
        const data = await response.json();
        return data;
    }

    async function getMovieByDateService(data) {
        const response = await fetch(MOVIES_URL+data.Date);
        const data = await response.json();
        return data;
    }

    async function searchMovieService(data) {
        const response = await fetch(MOVIES_URL+data.search);
        const data = await response.json();
        return data;
    }

}