import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WorkersComponent } from './workers/workers.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {WorkerService} from './services/worker.service';

@NgModule({
  declarations: [
    AppComponent,
    WorkersComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [WorkerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
