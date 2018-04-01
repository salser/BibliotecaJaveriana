import { Libro } from './libro';
import { Http, Response } from '@angular/http';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LibroService {

  constructor(private http: HttpClient) {
  }

  findAll() {
    return this.http.post('http://localhost:8080/libros/', '', {
      withCredentials: true
    });
  }

  findById(id: number) {
    return this.http.post('http://localhost:8080/libros/' + id, '', {
      withCredentials: true
    });
  }

  deleteById(id: number) {
    return this.http.post('http://localhost:8080/libros/eliminar/' + id, '', {
      withCredentials: true
    });
  }

  updateById(id: number, nombre: string, isbn: string, autores: string) {
    return this.http.
        post('http://localhost:8080/libros/actualizar/'
         + id + '/'
         + nombre + '/'
         + isbn + '/'
         + autores, '', {
           withCredentials: true
         });
  }

  insert(nombre: string, isbn: string, autores: string) {
    return this.http.
      post('http://localhost:8080/libros/insertar/'
        + nombre + '/'
        + isbn + '/'
        + autores, '', {
          withCredentials: true
        });
  }

  findAllPrestamos() {
    return this.http.post('http://localhost:8080/prestamos/', '', {
      withCredentials: true
    });
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

  getuser(username: string) {
    return this.http.post('http://localhost:8080/user/' + username, '', {
      withCredentials: true
    });
  }

  findUserById(id: number) {
    return this.http.post('http://localhost:8080/userId/' + id, '', {
      withCredentials: true
    });
  }

  findAllUsers() {
    return this.http.post('http://localhost:8080/users', '', {
      withCredentials: true
    });
  }

  getCurrentUser() {
    return this.http.post('http://localhost:8080/current-user', '', {
      withCredentials: true
    });
  }

  insertPrestamo(libro: number, user: string) {
    return this.http.
      post('http://localhost:8080//prestamos/insertar/'
        + libro + '/'
        + user + '/', '', {
          withCredentials: true
        });
  }

  logout() {
    return this.http.post('http://localhost:8080/logout', '', {
      withCredentials: true
    });
  }

  finishBook(id: number) {
    return this.http.post('http://localhost:8080/prestamos/devolucion/' + id + '/', '', {
      withCredentials: true
    });
  }
}
