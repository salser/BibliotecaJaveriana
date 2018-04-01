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
      .subscribe(data => {
        console.log(data);
        const result = [];
        const keys = Object.keys(data);
        keys.forEach(function (key) {
          result.push(data[key]);
        });
        console.log(keys.length);
        const librosAux: Libro[] = [];
        for (let i = 0; i < keys.length; i++) {
          const libro: Libro = new Libro();
          const key: any = keys[i];
          libro.nombre = data[key].nombre;
          libro.autores = data[key].autores;
          libro.isbn = data[key].isbn;
          libro.idLibro = data[key].idLibro;
          librosAux.push(libro);
        }
        this.libros = librosAux;
      }, error => {
        console.log(error.status);
        if (error.status === 403) {
          window.location.href = 'http://localhost:4200/biblioteca/login';
        }
      });
    this.selectedLibro = new Libro();
  }
  verLibroClick(id) {
    this.verLibro = true;
    this.idFind = id;
    // console.log('id: ' + id);
    this.service.findById(this.idFind)
      .subscribe(
        data => {
          const libro: Libro = new Libro();
          this.selectedLibro = <Libro> data;
          console.log(this.selectedLibro);
          /*libro.nombre = data[0].nombre;
          libro.isbn = data[0].isbn;
          libro.autores = data[0].autores;
          libro.idLibro = data[0].idLibro;*/
        },
        error => console.log('Error: ' + error));
  }

  eliminarLibro(id) {
    this.verLibro = false;
    this.deleteIt = confirm('Estas seguro?');
    if (this.deleteIt) {
      this.service.deleteById(id)
        .subscribe(
        data => alert('se eliminó ' + (<Libro>data).nombre + ' con ISBN: ' + (<Libro>data).isbn) ,
          error => console.log('Error: ' + error));
    }
    location.reload();
  }

  actualizarLibro(id) {
    this.service
      .updateById(
        this.selectedLibro.idLibro,
        this.selectedLibro.nombre,
        this.selectedLibro.isbn,
        this.selectedLibro.autores)
      .subscribe(
        data => {
          const libro: Libro = <Libro> data;
          alert('actualiza registro: Nombre: ' + libro.nombre + ' ISBN: ' + libro.isbn);
        },
        error => console.log('Error: ' + error)
      );
    location.reload();
  }

  hideDescription() {
    this.verLibro = false;
  }
}
