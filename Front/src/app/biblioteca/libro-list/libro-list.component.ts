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
  selectedLibro: Libro;
  idFind: number;
  constructor(private service: LibroService) {
    this.verLibro = false;
  }

  ngOnInit() {
    this.service.findAll()
      .subscribe(libros => this.libros = libros);
      this.selectedLibro = new Libro();
  }
  verLibroClick(id) {
    this.verLibro = true;
    this.idFind = id;
    console.log('id: ' + id);
    this.service.findById(this.idFind)
      .subscribe(
        libro => this.selectedLibro = libro,
        error => console.log('Error: ' + error));
  }

  eliminarLibro(id) {
    this.verLibro = false;
    confirm('Estas seguro?');
  }
}
