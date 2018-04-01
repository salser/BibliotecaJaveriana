import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Libro } from '../shared/libro';
import { LibroService } from '../shared/libro.service';

@Component({
  selector: 'app-libro-add',
  templateUrl: './libro-add.component.html',
  styleUrls: ['./libro-add.component.css']
})
export class LibroAddComponent implements OnInit {

  libro: Libro;
  insertMessage: string;
  showMessage: boolean;

  agregarLibro() {
      this.service
        .insert(
          this.libro.nombre,
          this.libro.isbn,
          this.libro.autores)
        .subscribe(
          libro => function() {
            console.log('inserta');
            this.showMessage = true;
            this.insertMessage = 'El libro: ' + this.libro.nombre + ' fue insertado satisfactoriamente';
           },
          error => console.log('Error: ' + error)
        );
    console.log('inserta');
    this.showMessage = true;
    this.insertMessage = 'El libro: ' + this.libro.nombre + ' fue insertado satisfactoriamente';
  }

  logout() {
    this.service.logout().subscribe();
    window.location.href = 'http://localhost:4200/';
  }
  constructor(private service: LibroService) {
    this.libro = new Libro();
    this.insertMessage = '';
    this.showMessage = false;
  }

  ngOnInit() {
  }

}
