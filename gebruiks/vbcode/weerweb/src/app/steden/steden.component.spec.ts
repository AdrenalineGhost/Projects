import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StedenComponent } from './steden.component';

describe('StedenComponent', () => {
  let component: StedenComponent;
  let fixture: ComponentFixture<StedenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StedenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StedenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
