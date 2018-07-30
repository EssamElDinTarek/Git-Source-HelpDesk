import { TestBed, inject } from '@angular/core/testing';

import { TicketCommentService } from './ticket-comment.service';

describe('TicketCommentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TicketCommentService]
    });
  });

  it('should be created', inject([TicketCommentService], (service: TicketCommentService) => {
    expect(service).toBeTruthy();
  }));
});
