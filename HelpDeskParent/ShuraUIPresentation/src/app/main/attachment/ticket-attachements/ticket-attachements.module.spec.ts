import { TicketAttachementsModule } from './ticket-attachements.module';

describe('TicketAttachementsModule', () => {
  let ticketAttachementsModule: TicketAttachementsModule;

  beforeEach(() => {
    ticketAttachementsModule = new TicketAttachementsModule();
  });

  it('should create an instance', () => {
    expect(ticketAttachementsModule).toBeTruthy();
  });
});
