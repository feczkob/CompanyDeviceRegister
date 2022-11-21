import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WorkersComponent} from './workers/workers.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {WorkerDetailComponent} from './worker-detail/worker-detail.component';

const routes: Routes = [
  {
    path: 'workers',
    component: WorkersComponent
  },
  {
    path: 'groups',
    component: GroupsComponent
  },
  {
    path: 'worker/:id',
    component: WorkerDetailComponent
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
