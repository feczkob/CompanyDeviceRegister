import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {WorkerService} from './services/worker.service';
import {WorkerButtonDirective} from './directives/worker-button.directive';
import { WorkerDetailComponent } from './worker-detail/worker-detail.component';
import {WorkerDetailRoutingModule} from './worker-detail/worker-detail-routing.module';
import { GroupDetailComponent } from './group-detail/group-detail.component';
import {GroupsModule} from "./groups/groups.module";
import {WorkersModule} from "./workers/workers.module";
import { DeviceDialogComponent } from './worker-detail/device-dialog/device-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    WorkerButtonDirective,
    WorkerDetailComponent,
    GroupDetailComponent,
    DeviceDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    WorkerDetailRoutingModule,
    GroupsModule,
    WorkersModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule
  ],
  providers: [WorkerService],
  bootstrap: [AppComponent],
})
export class AppModule { }
