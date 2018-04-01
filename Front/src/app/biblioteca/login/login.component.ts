import { Component, OnInit } from '@angular/core';
import { LibroService } from '../shared/libro.service';
import { FormsModule } from '@angular/forms';
import { Usuario } from './../shared/Usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = '';
  password = '';
  rol = '';
  message = '';
  showMessage: boolean;

  constructor(private loginService: LibroService) {
    this.showMessage = false;
   }

  ngOnInit() {}

  doLogin() {
    console.log(this.user + ' - ' + this.password);
    this.loginService.login(this.user, this.password).subscribe(data => {
      this.loginService.getuser(this.user).subscribe(
        user => {
          const usuario: Usuario = <Usuario> user;
          if (null != usuario) {
            this.rol = usuario.rol;
            if ('biblio' === this.rol) {
              window.location.href = 'http://localhost:4200/biblioteca/libro-list';
            } else {
              console.log('its a user!');
              window.location.href = 'http://localhost:4200/biblioteca/prestamos-list';
            }
          }
        },
        error => console.log(error)
      );
    }, error => {
      console.error(error);
      if (error.status === 401) {
        this.showMessage = true;
        this.message = 'Credenciales incorrectas';
      }
    });
  }

}
