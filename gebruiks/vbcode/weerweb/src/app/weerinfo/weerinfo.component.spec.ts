import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeerinfoComponent } from './weerinfo.component';

describe('WeerinfoComponent', () => {
  let component: WeerinfoComponent;
  let fixture: ComponentFixture<WeerinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WeerinfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WeerinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
