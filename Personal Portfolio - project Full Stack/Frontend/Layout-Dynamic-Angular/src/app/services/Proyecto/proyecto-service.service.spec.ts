import { TestBed } from '@angular/core/testing';

import { ProyectoServiceService } from './proyecto-service.service';

describe('ProyectoServiceService', () => {
  let service: ProyectoServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProyectoServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
