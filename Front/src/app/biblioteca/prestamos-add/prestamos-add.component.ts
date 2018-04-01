import { Component, OnInit } from '@angular/core';
import { Prestamo } from '../shared/Prestamo';
import { Usuario } from '../shared/Usuario';
import { LibroService } from '../shared/libro.service';
import { Libro } from '../shared/libro';

@Component({
  selector: 'app-prestamos-add',
  templateUrl: './prestamos-add.component.html',
  styleUrls: ['./prestamos-add.component.css']
})
export class PrestamosAddComponent implements OnInit {

  insertMessage: string;
  prestamo: Prestamo;
  showMessage: boolean;
  usuario: string;
  libros: Libro[];
  selectedLibro: number;

  constructor(private service: LibroService) {
    this.showMessage = false;
    this.selectedLibro = 1;
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
    this.service.getCurrentUser().subscribe(data => {
      console.log(data.username);
      this.usuario = data.username;
    });
  }

  agregarPrestamo() {
    console.log('selected: ' + this.selectedLibro);
    this.service.insertPrestamo(this.selectedLibro, this.usuario).subscribe(
      data => {
        this.showMessage = true;
        this.insertMessage = 'Prestamo instertado satisfactoriamente!';
      },
      error => {
        this.showMessage = true;
        this.insertMessage = 'Error insertando prestamo!';
    });
  }
}
