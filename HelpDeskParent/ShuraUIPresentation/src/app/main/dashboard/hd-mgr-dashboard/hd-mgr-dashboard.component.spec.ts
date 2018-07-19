import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HDMGRDashboardComponent } from './hd-mgr-dashboard.component';

describe('HDMGRDashboardComponent', () => {
  let component: HDMGRDashboardComponent;
  let fixture: ComponentFixture<HDMGRDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HDMGRDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HDMGRDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
