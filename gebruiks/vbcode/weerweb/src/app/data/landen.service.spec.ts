import { TestBed } from '@angular/core/testing';

import { LandenService } from './landen.service';

describe('LandenService', () => {
  let service: LandenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LandenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
