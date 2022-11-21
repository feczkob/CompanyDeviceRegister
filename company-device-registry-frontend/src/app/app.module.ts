import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WorkersComponent } from './workers/workers.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {WorkerService} from './services/worker.service';
import {WorkerButtonDirective} from './directives/worker-button.directive';
import { WorkerDetailComponent } from './worker-detail/worker-detail.component';
import {WorkerDetailRoutingModule} from './worker-detail/worker-detail-routing.module';
import { GroupsComponent } from './groups/groups.component';

@NgModule({
  declarations: [
    AppComponent,
    WorkersComponent,
    PageNotFoundComponent,
    WorkerButtonDirective,
    WorkerDetailComponent,
    GroupsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    WorkerDetailRoutingModule
  ],
  providers: [WorkerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
