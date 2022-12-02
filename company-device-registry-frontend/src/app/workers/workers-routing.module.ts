import {RouterModule, Routes} from "@angular/router";
import {GroupsComponent} from "../groups/groups.component";
import {WorkersComponent} from "./workers.component";
import {NgModule} from "@angular/core";


const routes: Routes = [{ path: '', component:
  WorkersComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class WorkersRoutingModule {}
