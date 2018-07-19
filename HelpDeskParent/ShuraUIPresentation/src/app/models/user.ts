import { Portfolio } from "./portfolio";
import { Project } from "./project";
export class User {
    userId: number;
    email: string;
    firstName: string;
    lastName: string;
    username: string;
    userPassword: string;
    portfolio: Portfolio;
    projects: Project[];
}