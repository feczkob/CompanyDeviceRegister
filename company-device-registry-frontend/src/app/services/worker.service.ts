import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


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
}
