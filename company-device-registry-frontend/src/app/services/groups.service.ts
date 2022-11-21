import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  private groupsUrl = '/api/group';

  constructor(private http: HttpClient) {
  }

  getGroups(): Observable<Group[]> {

  }
}
