import {NgModule} from "@angular/core";
import {GroupsComponent} from "./groups.component";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {GroupsRoutingModule} from "./groups-routing.module";
import {GroupWorkersComponent} from "../group-workers/group-workers.component";


@NgModule({
  declarations: [
    GroupsComponent,
    GroupWorkersComponent
  ],
  exports: [
    GroupWorkersComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    GroupsRoutingModule
  ]
})
export class GroupsModule {}
