import { BoardGame } from "./board-game"

export class User {
    id?: string
    username?: string
    email?: string
    password?: string
    ownedBoardGames?: BoardGame[]
    wishList?: BoardGame[]
    friends?: User[] 

    constructor(username: string, email: string, password: string){
        this.username = username;
        this.email = email;
        this.password = password;
    }
}



