import { LibroService } from './../shared/libro.service';
import { Libro } from './../shared/libro';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

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
  deleteIt: boolean;
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
    this.deleteIt = confirm('Estas seguro?');
    if (this.deleteIt) {
      this.service.deleteById(id)
        .subscribe(
          libro => console.log('elimina'),
          error => console.log('Error: ' + error));
      this.ngOnInit();
    }
  }

  actualizarLibro(id) {
    this.service
      .updateById(
        this.selectedLibro.idLibro,
        this.selectedLibro.nombre,
        this.selectedLibro.isbn,
        this.selectedLibro.autores)
      .subscribe(
        libro => console.log('actualiza'),
        error => console.log('Error: ' + error)
      );
    this.ngOnInit();
  }

  hideDescription() {
    this.verLibro = false;
  }
}
