import { Portfolio } from "./portfolio";
import { Project } from "./project";
export class User {
    userId: number;
    emailAddress: string;
    email: string;
    firstName: string;
    lastName: string;
    userName: string;
    userPassword: string;
    portfolio: Portfolio;
    projects: Project[];
}