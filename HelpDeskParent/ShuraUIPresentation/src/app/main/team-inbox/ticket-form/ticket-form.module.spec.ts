import { TicketFormModule } from './ticket-form.module';

describe('TicketFormModule', () => {
  let ticketFormModule: TicketFormModule;

  beforeEach(() => {
    ticketFormModule = new TicketFormModule();
  });

  it('should create an instance', () => {
    expect(ticketFormModule).toBeTruthy();
  });
});
