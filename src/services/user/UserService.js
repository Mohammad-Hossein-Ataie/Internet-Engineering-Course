import { DOMAIN, USER_LOGIN_URL, USER_LOGOUT_URL } from "../../config/config";


export default function UserService() {

    async function LoginUserService(url, data) {
        console.log("🚀 ~ file: UserService.js ~ line 7 ~ UserService ~ data", DOMAIN + url);

        const response = await fetch(DOMAIN + url, {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return response.json();
    }
    async function LogoutUserService(data) {
        const response = await fetch(USER_LOGOUT_URL, {
            method: 'POST',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
    }
}
