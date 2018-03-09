import { TestBed, inject } from '@angular/core/testing';

import { LibroListComponent } from './libro-list.component';
import { LibroService } from '../shared/libro.service';

describe('LibroListComponent', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LibroService]
    });
  });

  it('should be created', inject([LibroService], (service: LibroService) => {
    expect(service).toBeTruthy();
  }));
});
