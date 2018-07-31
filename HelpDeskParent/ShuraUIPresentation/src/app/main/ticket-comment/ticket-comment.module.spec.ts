import { TicketCommentModule } from './ticket-comment.module';

describe('TicketCommentModule', () => {
  let ticketCommentModule: TicketCommentModule;

  beforeEach(() => {
    ticketCommentModule = new TicketCommentModule();
  });

  it('should create an instance', () => {
    expect(ticketCommentModule).toBeTruthy();
  });
});
