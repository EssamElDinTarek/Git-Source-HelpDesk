import { Component, OnInit, OnDestroy, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material';
import { fuseAnimations } from '@fuse/animations';
import { Portfolio } from '../../../models/portfolio';
import { Project } from '../../../models/project';


@Component({
  selector: 'app-lookup-management',
  encapsulation: ViewEncapsulation.None,
  templateUrl: './lookup-management.component.html',
  styleUrls: ['./lookup-management.component.scss'],
  animations: fuseAnimations
})

export class LookupManagementComponent implements OnInit, OnDestroy {
  form: FormGroup;
  lookupTypes: string[] = ["Project", "Portofolio", "user", "Team"];
  selectedLookupType: string = this.lookupTypes[0];
  selectedLookupTypeIdentifire:string="";
  lookUpDataSource = new MatTableDataSource();
  inputObject:any;
  selectedProject:Project = new Project();

  /** End of static defination calles */
  /** To be Replaced by rest calls requests*/

  portfolioList: Portfolio[] = [
    { portfolioId: 1, name: "Portfolio 1", managerLogjn: "user 1" },
    { portfolioId: 2, name: "Portfolio 2", managerLogjn: "user 2" },
    { portfolioId: 3, name: "Portfolio 3", managerLogjn: "user 3" }
  ];
  projectList: Project[] = [
    { projectId: 1, name: "Project 1" },
    { projectId: 2, name: "Project 2" },
    { projectId: 3, name: "Project 3" }
  ];
  /** End of static defination calles */
  //////////////////////////////////////////////

  displayedColumns:string[];
  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {
    console.log(Validators.required);
    this.changeLockup();
  }
  ngOnDestroy() {
    console.log("ngOnDestroy");
  }
  lookupTypesChange(){
    console.log("event");
    this.changeLockup();
  }
  onSubmit(currentForm: FormGroup):void{
    console.log("currentForm : " + currentForm );
  }
  changeLockup():void{
    this.form = new FormGroup({
      selectedLookupType: new FormControl()
    });
    if(this.selectedLookupType == "Portofolio"){
      this.lookUpDataSource.data = this.portfolioList;
      this.displayedColumns = ['name', 'managerLogjn','portfolioId'];
      this.selectedLookupTypeIdentifire = "portfolioId";
      this.inputObject = new Portfolio();
    } else if(this.selectedLookupType == "Project"){
      this.lookUpDataSource.data = this.projectList;
      this.displayedColumns = ['name','projectId'];
      this.selectedLookupTypeIdentifire = "projectId";
      this.inputObject = new Project();
    }
    for (let index = 0; index < this.displayedColumns.length; index++) {
      const element = this.displayedColumns[index];
      this.form.addControl(element,new FormControl());
    }
  }
  addLookup(element):void{
    console.log("inputObject : " + JSON.stringify(this.inputObject));
    console.log("element : " + JSON.stringify(element.toString()));
  }
  updateLookup(lookupObject):void{
    console.log("lookupObject : " || lookupObject);
  }
  deleteLookup(lookupObject):void{
    console.log("lookupObject : " || lookupObject);
  }
}
