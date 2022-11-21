import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WorkersComponent} from './workers/workers.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path: 'workers',
    component: WorkersComponent
  },
  {
    path: '',
    redirectTo: '/workers',
    pathMatch: 'full'
  },
  {
    path: '**',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
