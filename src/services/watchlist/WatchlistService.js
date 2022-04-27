import {WATCHLIST_URL} from '../../config/config';

export default function WatchlistService() {

    async function getWatchlistService() {
        const response = await fetch(WATCHLIST_URL);
        const data = await response.json();
        return data;
    }

    async function addToWatchlistService(data) {
        const response = await fetch(WATCHLIST_URL+data.movieId);
    }
}