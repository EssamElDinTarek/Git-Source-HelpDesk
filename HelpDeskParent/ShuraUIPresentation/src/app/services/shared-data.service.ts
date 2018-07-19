import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { Project } from '../models/project';
@Injectable({
  providedIn: 'root'
})
export class SharedDataService {

  user: User;
  selectedProject: Project;
  constructor() { }
}
