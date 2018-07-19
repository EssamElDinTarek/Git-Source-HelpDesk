import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HDURSDashboardComponent } from './hd-urs-dashboard.component';

describe('HDURSDashboardComponent', () => {
  let component: HDURSDashboardComponent;
  let fixture: ComponentFixture<HDURSDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HDURSDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HDURSDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
