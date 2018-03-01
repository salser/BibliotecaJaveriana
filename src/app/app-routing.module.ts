import { LibroAddComponent } from './biblioteca/libro-add/libro-add.component';
import { LibroViewComponent } from './biblioteca/libro-view/libro-view.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibroListComponent } from './biblioteca/libro-list/libro-list.component';

const routes: Routes = [
  { path: 'biblioteca/libro-list', component: LibroListComponent },
  { path: 'biblioteca/libro-view/:id', component: LibroViewComponent },
  { path: '', pathMatch: 'full', redirectTo: 'biblioteca/libro-list' },
  { path: 'biblioteca/libro-add', component: LibroAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
