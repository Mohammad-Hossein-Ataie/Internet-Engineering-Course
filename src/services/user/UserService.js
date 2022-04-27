import {USER_LOGIN_URL, USER_LOGOUT_URL} from "../../config/config";


export default function UserService() {

    async function LoginUserService (data) {
        const response = await fetch(USER_LOGIN_URL, {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return response.json();
    }
    async function LogoutUserService (data) {
        const response = await fetch(USER_LOGOUT_URL , {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
    }
}
