import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog, MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { SharedDataService } from '../../../services/shared-data.service';
import { TicketCommentService, CommentResponse } from '../../../services/ticket-comment.service';
import { TicketComment } from '../../../model/TicketComment';
import { DialogOverviewExampleDialog } from '../../dialog-overview/dialog-overview-example.component';
import { ActivatedRoute } from '@angular/router';
import { TicketService } from '../../../services/ticket.service';
import { Ticket } from '../../../models/ticket';

@Component({
  selector: 'app-ticket-comment',
  templateUrl: './ticket-comment.component.html',
  styleUrls: ['./ticket-comment.component.scss']
})
export class TicketCommentComponent implements OnInit {

  @Input('updatedTicketId') ticketID: number;

  formData: FormData = new FormData();
  filelist: FileList;
  displayedColumns = ['commentValue', 'user', 'delete'];
  comments = new MatTableDataSource();
  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  fileUploaded: boolean;
  commentsResponse: CommentResponse = new CommentResponse();

  addedComment: TicketComment;

  //child: Comment;
  commentInDialog: string;
  commentDialogName: string = "Comment";
  commentDialogMessage: string = "Add Your Comment here";
  commentDialogOkLabel: string = "Ok";
  commentDialogCancelLabel: string = "Cancel";
  commentConfirmed: boolean = false;
  ticket: Ticket = new Ticket(this.ticket);

  constructor(private http: HttpClient, public dialog: MatDialog,private _ticketService: TicketService, private _shareData: SharedDataService, private commentService: TicketCommentService,private route: ActivatedRoute) { }

  ngOnInit() {
    this.commentsResponse.data = new Array<TicketComment>();

    /* console.log('this.route : '+ JSON.stringify(this.route.params) );
        this.route.params.subscribe(_params => {
            this.ticketID = _params['ticketId'];
            console.log("params : "+_params);
            console.log("updatedTicketId : " + this.ticketID);
        }); */
  }
  ngAfterViewInit() {
    //get ticket id and user id to add comment
    //this.ticketID = 4952;
    //this.user.userId = 1;
    console.log('on after view init');
    this.commentService.getCommentByTickId(this.ticketID).subscribe(_commentsResponse => {
      this.commentsResponse.status = _commentsResponse.status;
      for (let index = 0; index < _commentsResponse.data.length; index++) {
        this.commentsResponse.data[index] = _commentsResponse.data[index];
      }
      
      this.comments.data = this.commentsResponse.data;
    });
    // to moved inside the success senario in the above request
    //this. isLoadingResults = false;
  }

  addComment(comment : TicketComment){
    //var newComment : TicketComment;
    comment.hduser = this._shareData.user;
    this.commentService.addTicketComment(comment).subscribe(_ticket => {
      alert('comment added successfully');
      comment.writtenOn = new Date()+'';
      this.commentsResponse.data[this.commentsResponse.data.length] = comment;
      this.comments.data = this.commentsResponse.data;
      this.addedComment = null;
   });
  }

  postComment(comment:string){

    if (comment != null && comment != undefined && comment != "") {

    this.addedComment = new TicketComment();
    this.addedComment.commentValue = comment;
    this.addedComment.hduser = this._shareData.user;
    this.addedComment.ticketId = this.ticketID;
    this.addComment(this.addedComment);
    } else {
      alert("No Comment Added to Post");
    }

  }

  delete(comment: TicketComment): void {
    this.commentService.deleteComment(comment).subscribe();
    this.comments.data = this.comments.data.filter(h => h !== comment);
    location.reload;
  }

  /* openDialog(): void {
    let dialogRef = this.dialog.open(DialogOverviewExampleDialog, {
      width: '250px',
      data: { 
        dialogName: this.commentDialogName, 
        dialogMessage: this.commentDialogMessage, 
        dialogOkLabel: this.commentDialogOkLabel, 
        dialogCancelLabel: this.commentDialogCancelLabel, 
        conbfirmed: this.commentConfirmed, 
        confirmationComment: this.commentInDialog 
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      this.commentConfirmed = result.confirmed;
      console.log(this.commentConfirmed);
      if (this.commentConfirmed) {
        this.addedComment = new TicketComment();
        this.addedComment.commentValue = result.confirmationComment;
        this.addedComment.hduser = this._shareData.user;
        this.addedComment.ticketId = this.ticketID;
        this.addComment(this.addedComment);
      }
    });
  } */

}
