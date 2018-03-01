import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-libro-view',
  templateUrl: './libro-view.component.html',
  styleUrls: ['./libro-view.component.css']
})
export class LibroViewComponent implements OnInit {

  idLibro: number;

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.route.params.
            subscribe(params => this.idLibro = +params['id']);
  }

}
