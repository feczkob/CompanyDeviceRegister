import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Worker} from '../workers/model/worker.model';


@Injectable({
  providedIn: 'root'
})
export class WorkerService {
  private workerUrl = 'api/worker';

  constructor(private http: HttpClient) {
  }

  getWorkers(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.workerUrl + "/getAll");
  }

  getWorkerById(id: string): Observable<Worker> {
    return this.http.get<Worker>(this.workerUrl + "/" + id);
  }

  downloadReport(id: string): Observable<HttpResponse<Blob>> {
    return this.http.get(this.workerUrl + "/downloadWorker/" + id, {observe: 'response', responseType: 'blob'});
  }
}
