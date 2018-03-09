import { LibroService } from './../shared/libro.service';
import { Libro } from './../shared/libro';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-libro-list',
  templateUrl: './libro-list.component.html',
  styleUrls: ['./libro-list.component.css']
})
export class LibroListComponent implements OnInit {

  libros: Libro[];
  verLibro: boolean;
  constructor(private service: LibroService) {
    this.verLibro = false;
  }

  ngOnInit() {
    this.service.findAll()
      .subscribe(libros => this.libros = libros);
  }
  verLibroClick() {
    this.verLibro = true;
  }

  eliminarLibro() {
    this.verLibro = false;
    confirm('Estas seguro?');
  }
}
