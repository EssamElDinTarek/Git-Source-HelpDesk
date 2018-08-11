import { User } from "../models/user";

export const UserData: User = {

  userId: 123,
  firstName: '',
  email:'ahmed.farrag',
  lastName: '',
  emailAddress: 'ahmed.farrag',
  userPassword: '123456',
  userName: 'ahmed.farrag',
  portfolio: {portfolioId: 1, name: 'asd', managerLogjn: ''},
  projects: [{projectId: 1, name: 'sbmhelpdesk' ,portfolio: {portfolioId: 1, name: 'asd', managerLogjn: ''}}, {projectId: 2, name: 'sbmshura',portfolio: {portfolioId: 1, name: 'asd', managerLogjn: ''}}]
};