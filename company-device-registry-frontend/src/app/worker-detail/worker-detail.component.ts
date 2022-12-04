import { Component, OnInit } from '@angular/core';
import {Worker} from '../workers/model/worker.model';
import {ActivatedRoute} from '@angular/router';
import {WorkerService} from '../services/worker.service';
import {Location} from '@angular/common';
import {HttpResponse} from '@angular/common/http';

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

  download() {
    this.workerService.downloadReport(this.worker!.workerId.toString())
      .subscribe((response: HttpResponse<Blob>): void => {
        const file = new Blob([response.body as BlobPart],  { type: "application/pdf" });
        let fileName = response.headers.get('content-disposition')!;
        fileName = fileName?.substring(fileName.lastIndexOf("filename=") + "filename=".length);

        const data = window.URL.createObjectURL(file);
        const link = document.createElement('a');
        link.href = data;
        link.download = fileName!;
        // this is necessary as link.click() does not work on the latest firefox
        link.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true, view: window }));

        setTimeout(function () {
          // For Firefox it is necessary to delay revoking the ObjectURL
          window.URL.revokeObjectURL(data);
          link.remove();
        }, 100);

      });
  }
}
