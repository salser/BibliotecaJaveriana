import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Libro } from '../shared/libro';

@Component({
  selector: 'app-libro-add',
  templateUrl: './libro-add.component.html',
  styleUrls: ['./libro-add.component.css']
})
export class LibroAddComponent implements OnInit {

  libro: Libro;

  agregarLibro() {
    // TODO agregar a la base de datos
    console.log('Agrega libro');
  }
  constructor() {
    this.libro = new Libro();
  }

  ngOnInit() {
  }

}
