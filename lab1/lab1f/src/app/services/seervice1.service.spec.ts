import { TestBed } from '@angular/core/testing';

import { Seervice1Service } from './seervice1.service';

describe('Seervice1Service', () => {
  let service: Seervice1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Seervice1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
