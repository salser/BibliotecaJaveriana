import { Component, OnInit } from '@angular/core';
import { LibroService } from '../shared/libro.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = '';
  password = '';

  result: any;

  message: any;

  constructor(private loginService: LibroService) { }

  ngOnInit() {}

  doLogin() {
    console.log(this.user + ' - ' + this.password);
    this.loginService.login(this.user, this.password).subscribe(data => {
      alert(data);
      window.location.href = 'http://localhost:4200/biblioteca/libro-list';
    }, error => {
      console.error(error);
      this.message = JSON.stringify(error);
    });
  }

}
