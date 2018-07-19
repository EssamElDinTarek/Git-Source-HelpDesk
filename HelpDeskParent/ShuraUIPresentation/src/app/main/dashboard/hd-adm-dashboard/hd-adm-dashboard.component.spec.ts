import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HDADMDashboardComponent } from './hd-adm-dashboard.component';

describe('HDADMDashboardComponent', () => {
  let component: HDADMDashboardComponent;
  let fixture: ComponentFixture<HDADMDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HDADMDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HDADMDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
