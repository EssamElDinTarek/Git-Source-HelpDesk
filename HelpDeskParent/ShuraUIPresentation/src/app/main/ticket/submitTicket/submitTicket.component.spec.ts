import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubmitTicketComponent } from './submitTicket.component';

describe('submitTicketComponent', () => {
  let component: SubmitTicketComponent;
  let fixture: ComponentFixture<SubmitTicketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubmitTicketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubmitTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
