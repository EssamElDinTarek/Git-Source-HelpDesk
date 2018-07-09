export class Auth {
    grant_type: string;
    username: string;
    password: string;
    client_id: string;
    
    access_token: string;
    token_type: string;
    refresh_token: string;
    expires_in: string;
    scope: string;

    constructor() {
    }
}