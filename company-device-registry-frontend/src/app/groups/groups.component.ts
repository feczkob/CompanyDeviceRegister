import { Component, OnInit } from '@angular/core';
import {GroupsService} from '../services/groups.service';
import {Group} from './model/group.model';

@Component({
  selector: 'app-groups',
  templateUrl: './groups.component.html',
  styleUrls: ['./groups.component.css']
})
export class GroupsComponent implements OnInit {

  groups: Group[] = [];

  constructor(private groupService: GroupsService) { }

  ngOnInit(): void {
    this.initGroups();
  }

  private initGroups() {
    this.groupService.getGroups().subscribe(groups => this.groups = groups);
  }
}
