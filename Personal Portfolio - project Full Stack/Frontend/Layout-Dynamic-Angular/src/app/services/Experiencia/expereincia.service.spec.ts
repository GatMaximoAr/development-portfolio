import { TestBed } from '@angular/core/testing';

import { ExperienciaService } from './experiencia.service';

describe('DataService', () => {
  let service: ExperienciaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExperienciaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
