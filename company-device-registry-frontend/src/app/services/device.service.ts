import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Device} from '../workers/model/device.model';


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

  addDevice(data: Device) : Observable<Device> {
    return this.http.post<Device>(this.deviceUrl, data);
  }
}
