import { LibroAddComponent } from './biblioteca/libro-add/libro-add.component';
import { LibroViewComponent } from './biblioteca/libro-view/libro-view.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibroListComponent } from './biblioteca/libro-list/libro-list.component';
import { LoginComponent } from './biblioteca/login/login.component';
import { PrestamosListComponent } from './biblioteca/prestamos-list/prestamos-list.component';
import { PrestamosAddComponent } from './biblioteca/prestamos-add/prestamos-add.component';

const routes: Routes = [
  { path: 'biblioteca/libro-list', component: LibroListComponent },
  { path: 'biblioteca/libro-view/:id', component: LibroViewComponent },
  { path: '', pathMatch: 'full', redirectTo: 'biblioteca/login' },
  { path: 'biblioteca/libro-add', component: LibroAddComponent },
  { path: 'biblioteca/login', component: LoginComponent },
  // { path: '**', component: LoginComponent}, // 404NotFound
  { path: 'biblioteca/prestamos-list', component: PrestamosListComponent},
  { path: 'biblioteca/prestamos-add', component: PrestamosAddComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

