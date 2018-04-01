import { Component, OnInit } from '@angular/core';
import { Prestamo } from '../shared/Prestamo';
import { LibroService } from '../shared/libro.service';

@Component({
  selector: 'app-prestamos-list',
  templateUrl: './prestamos-list.component.html',
  styleUrls: ['./prestamos-list.component.css']
})
export class PrestamosListComponent implements OnInit {

  prestamos: Prestamo[];

  constructor(private service: LibroService) { }

  ngOnInit() {
    this.service.getCurrentUser().subscribe(data => this.usuario = data.username);

    this.service.findAllPrestamos()
      .subscribe(data => {
        console.log(data);
        const result = [];
        const keys = Object.keys(data);
        keys.forEach(function (key) {
          result.push(data[key]);
        });
        console.log(keys.length);
        const prestamosAux: Prestamo[] = [];
        for (let i = 0; i < keys.length; i++) {
          const prestamo: Prestamo = new Prestamo();
          const key: any = keys[i];
          prestamo.idPrestamo = data[key].idPrestamo;
          prestamo.fechaPrestamo = data[key].fechaPrestamo;
          prestamo.fechaDevolucion = data[key].fechaDevolucion;
          prestamo.fechaVencimiento = data[key].fechaVencimiento;
          prestamo.usuario = data[key].usuario;
          prestamo.libro = data[key].libro;
          if (this.usuario === prestamo.usuario.usuario) {
            prestamosAux.push(prestamo);
          }
        }
        this.prestamos = prestamosAux;
      }, error => {
        console.log(error.status);
        if (error.status === 403) {
          window.location.href = 'http://localhost:4200/biblioteca/login';
        }
      });

  }

  finalizarPrestamo(idPrestamo) {
    console.log('finish');
    this.service.finishBook(idPrestamo).subscribe(data => location.reload());
  }

}
