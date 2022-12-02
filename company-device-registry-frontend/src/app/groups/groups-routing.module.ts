import {RouterModule, Routes} from "@angular/router";
import {GroupsComponent} from "./groups.component";
import {NgModule} from "@angular/core";


const routes: Routes = [{ path: '', component:
  GroupsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GroupsRoutingModule { }
