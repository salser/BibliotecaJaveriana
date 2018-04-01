import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LibroListComponent } from './biblioteca/libro-list/libro-list.component';
import { LibroViewComponent } from './biblioteca/libro-view/libro-view.component';
import { LibroAddComponent } from './biblioteca/libro-add/libro-add.component';
import { FormsModule } from '@angular/forms';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { HttpClientModule } from '@angular/common/http';
import { LibroService } from './biblioteca/shared/libro.service';
import { LoginComponent } from './biblioteca/login/login.component';
import { PrestamosListComponent } from './biblioteca/prestamos-list/prestamos-list.component';
import { PrestamosAddComponent } from './biblioteca/prestamos-add/prestamos-add.component';



@NgModule({
  declarations: [
    AppComponent,
    LibroListComponent,
    LibroViewComponent,
    LibroAddComponent,
    LoginComponent,
    PrestamosListComponent,
    PrestamosAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AngularFontAwesomeModule
  ],
  providers: [LibroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
