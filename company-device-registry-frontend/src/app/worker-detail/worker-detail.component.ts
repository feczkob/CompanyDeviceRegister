import { Component, OnInit } from '@angular/core';
import {Worker} from '../workers/model/worker.model';
import {ActivatedRoute} from '@angular/router';
import {WorkerService} from '../services/worker.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-worker-detail',
  templateUrl: './worker-detail.component.html',
  styleUrls: ['./worker-detail.component.css']
})
export class WorkerDetailComponent implements OnInit {

  worker : Worker | undefined;

  constructor(private route: ActivatedRoute,
              private workerService: WorkerService,
              private location: Location) { }

  ngOnInit(): void {
    this.initWorker();
  }

  private initWorker() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.workerService.getWorkerById(id.toString())
      .subscribe(worker => {
        this.worker = worker;
      });
  }

  goBack() {
    this.location.back();
  }
}
