import {Component, OnInit} from '@angular/core';
import {WorkerService} from '../services/worker.service';
import {Worker} from './model/worker.model';

@Component({
  selector: 'app-workers',
  templateUrl: './workers.component.html',
  styleUrls: ['./workers.component.css']
})
export class WorkersComponent implements OnInit {

  workers : Worker[] = [];

  constructor(private workerService: WorkerService) { }

  ngOnInit(): void {
    this.initWorkers();
  }

  private initWorkers() {
    this.workerService.getWorkers().subscribe(workers => this.workers = workers);
  }
}
