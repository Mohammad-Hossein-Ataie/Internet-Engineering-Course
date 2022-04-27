import {} from '../../config/config';

export default function ActorService() {

    async function getActorByIdService(data){
        const response = await fetch(ACTORS_URL+data.actorId);
        const data = await response.json();
        return data;
    }
}