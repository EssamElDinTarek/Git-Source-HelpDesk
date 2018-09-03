import { Component, OnDestroy, OnInit, Inject, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';


import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatSpinner, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { merge, Observable, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators'
import { Location } from '@angular/common';
import { SharedDataService } from '../../../services/shared-data.service';
import { FileData } from '../../../model/fileData';
import { Attachment } from '../../../model/attachment';
import { AttachmentService, AttachmentResponse } from './../attachment.service';

@Component({
  selector: 'app-ticket-attachements',
  templateUrl: './ticket-attachements.component.html',
  styleUrls: ['./ticket-attachements.component.scss']
})
export class TicketAttachementsComponent implements OnInit, AfterViewInit {

  @Input('updatedTicketId') ticketID: number;

  formData: FormData = new FormData();
  filelist: FileList;
  userID:number;
  displayedColumns = ['name', 'description', 'type',  'size',  'ModifiedDate', 'user', 'delete'];
  attachments = new MatTableDataSource();
  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  attachmentResponse: AttachmentResponse = new AttachmentResponse();
  //fileUploaded:boolean;
  


  constructor(private http: HttpClient, public dialog: MatDialog, private _shareData: SharedDataService, private attachService: AttachmentService) { }

  ngOnInit() {
    this.attachmentResponse.data = new Array<Attachment>();
    this.userID = this._shareData.user.userId;
    
  }
  ngAfterViewInit() {
    //get ticket id and user id to upload attachment
    this.userID = this._shareData.user.userId;
    this.ticketID = +this.ticketID;
    console.log('on after view init');
    // If the user changes the sort order, reset back to the first page.
    this.attachService.getAttachmentByTickId(this.ticketID).subscribe(_attachmentResponse => {
      this.attachmentResponse = _attachmentResponse;
      for (let index = 0; index < _attachmentResponse.data.length; index++) {
        this.attachmentResponse.data[index].uploaded = true;
        //this.fileUploaded = this.attachmentResponse.data[index].uploaded ;
      }
      
      this.attachments.data = this.attachmentResponse.data;

    });
    // to moved inside the success senario in the above request
    //this. isLoadingResults = false;
  }
  delete(attachment: Attachment): void {
    this.attachments.data = this.attachments.data.filter(h => h !== attachment);
    this.attachService.deleteAttachment(attachment).subscribe();
    location.reload;
  }

  download(attachment: Attachment): void {
    this.attachments.data = this.attachments.data.filter(h => h !== attachment);
    this.attachService.deleteAttachment(attachment).subscribe();
    location.reload;
  }

  upload(attachment: Attachment): void {
     

    this.formData.append('TICKET_ID', JSON.stringify(this.ticketID));
    this.formData.append('files', attachment.file);
    this.formData.append('USER_ID',JSON.stringify(this.userID));

    this.attachService.addAttachment(this.formData).subscribe(_ticket => {
      alert('attachment added successfully');
      attachment.uploaded=true;
    });
  }


  fileChange(files: FileList) {
    this.filelist = files;
    var attachment: Attachment;
    console.log("files : " + files.length);
    for (let i = 0; i < files.length; i++) {
      let file: FileData = new FileData();
      file.name = files.item(i).name;
      file.size = files.item(i).size;
      file.ModifiedDate = files.item(i).lastModifiedDate;
      file.type = files.item(i).type;

      attachment = new Attachment();
      attachment.name = files.item(i).name;
      attachment.size = files.item(i).size;
      attachment.type = files.item(i).type;
      attachment.ModifiedDate = files.item(i).lastModifiedDate;
      attachment.uploaded = false;
      attachment.file = files.item(i);
      this.attachmentResponse.data[this.attachmentResponse.data.length] = attachment;
      this.attachments.data = this.attachmentResponse.data;
    }

  }
}
