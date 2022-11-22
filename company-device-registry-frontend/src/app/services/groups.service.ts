import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Group} from '../groups/model/group.model';

@Injectable({
  providedIn: 'root'
})
export class GroupsService {

  private groupsUrl = '/api/group';

  constructor(private http: HttpClient) {
  }

  getGroups(): Observable<Group[]> {
    return this.http.get<Group[]>(this.groupsUrl + "/getAll");
  }

  getGroupById(id: string): Observable<Group> {
    return this.http.get<Group>(this.groupsUrl + "/" + id);
  }
}
