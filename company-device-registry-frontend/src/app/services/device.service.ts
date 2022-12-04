import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  private deviceUrl = 'api/device';

  constructor(private http: HttpClient) {
  }

  deleteDevice(id: string): Observable<any> {
    return this.http.delete(this.deviceUrl + "/" + id);
  }
}
