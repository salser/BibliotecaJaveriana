import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LibroListComponent } from './biblioteca/libro-list/libro-list.component';
import { LibroViewComponent } from './biblioteca/libro-view/libro-view.component';
import { LibroAddComponent } from './biblioteca/libro-add/libro-add.component';


@NgModule({
  declarations: [
    AppComponent,
    LibroListComponent,
    LibroViewComponent,
    LibroAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
