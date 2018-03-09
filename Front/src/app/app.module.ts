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


@NgModule({
  declarations: [
    AppComponent,
    LibroListComponent,
    LibroViewComponent,
    LibroAddComponent
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
