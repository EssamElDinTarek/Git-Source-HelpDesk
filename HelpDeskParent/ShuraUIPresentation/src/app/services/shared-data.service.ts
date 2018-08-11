import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Project } from '../models/project';
import { Portfolio } from '../models/portfolio';

@Injectable({
  providedIn: 'root'
})
export class SharedDataService {

  user: User = new User();
  projects: Project[]=[];
  portfolio: Portfolio;
  selectedProject: Project;
  showContent:boolean= false;
  constructor() { }
}
