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

  deleteById(id: number): Observable<Libro> {
    return this.http.get<Libro>('http://localhost:8080/libros/eliminar/' + id);
  }

  updateById(id: number, nombre: string, isbn: string, autores: string): Observable<Libro> {
    return this.http.
        get<Libro>('http://localhost:8080/libros/actualizar/'
         + id + '/'
         + nombre + '/'
         + isbn + '/'
         + autores);
  }

  insert(nombre: string, isbn: string, autores: string): Observable<Libro> {
    return this.http.
      get<Libro>('http://localhost:8080/libros/insertar/'
        + nombre + '/'
        + isbn + '/'
        + autores);
  }

}
