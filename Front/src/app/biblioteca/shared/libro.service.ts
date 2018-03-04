import { Libro } from './libro';
import { Injectable } from '@angular/core';

@Injectable()
export class LibroService {

  l1: Libro;
  l2: Libro;
  constructor() {
    this.l1 = new Libro();
    this.l2 = new Libro();
    this.l1.setData(1, '50 sombras de carlos', '789-987', 'Jose Dom');
    this.l2.setData(2, '50 sombras de jose', '420-420', 'Carlos Qui');
   }

}
