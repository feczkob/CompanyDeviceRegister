import {RouterModule, Routes} from '@angular/router';
import {WorkerDetailComponent} from './worker-detail.component';
import {NgModule} from '@angular/core';


const routes: Routes = [
  {
    path: '',
    component: WorkerDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkerDetailRoutingModule {}
