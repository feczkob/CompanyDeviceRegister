import {NgModule} from "@angular/core";
import {WorkersComponent} from "./workers.component";
import {WorkerDetailComponent} from "../worker-detail/worker-detail.component";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {WorkersRoutingModule} from "./workers-routing.module";


@NgModule({
  declarations: [
    WorkersComponent,
  ],
  imports: [
    FormsModule,
    CommonModule,
    WorkersRoutingModule
  ]
})
export class WorkersModule {}
