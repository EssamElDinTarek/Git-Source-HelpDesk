import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TicketAttachementsComponent } from './ticket-attachements.component';

describe('TicketAttachementsComponent', () => {
  let component: TicketAttachementsComponent;
  let fixture: ComponentFixture<TicketAttachementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TicketAttachementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TicketAttachementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
