import { Libro } from './libro';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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

  login(username: string, password: string) {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    const params = new HttpParams()
      .set('username', username)
      .set('password', password);
    return this.http.post('http://localhost:8080/login', null, {
      headers: headers,
      params: params,
      withCredentials: true
    });
  }

}
