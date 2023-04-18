import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotifDetailComponent } from './notif-detail.component';

describe('NotifDetailComponent', () => {
  let component: NotifDetailComponent;
  let fixture: ComponentFixture<NotifDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotifDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotifDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
