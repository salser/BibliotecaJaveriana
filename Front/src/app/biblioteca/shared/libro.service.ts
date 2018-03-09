import { Libro } from './libro';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LibroService {

  constructor(private http: HttpClient) {
   }
   findAll(): Observable<Libro[]> {
    return this.http.get<Libro[]>('http://localhost:8080/libros');
  }

  findById(id: number): Observable<Libro> {
    return this.http.get<Libro>('http://localhost:8080/libros/' + id);
  }

}
