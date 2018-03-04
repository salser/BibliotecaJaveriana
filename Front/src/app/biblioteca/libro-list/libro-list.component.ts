import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-libro-list',
  templateUrl: './libro-list.component.html',
  styleUrls: ['./libro-list.component.css']
})
export class LibroListComponent implements OnInit {

  verLibro: boolean;
  constructor() {
    this.verLibro = false;
  }

  verLibroClick() {
    this.verLibro = true;
  }

  eliminarLibro() {
    this.verLibro = false;
    confirm('Estas seguro?');
  }

  ngOnInit() {
  }

}
