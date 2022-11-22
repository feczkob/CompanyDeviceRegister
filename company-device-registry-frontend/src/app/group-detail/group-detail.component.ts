import { Component, OnInit } from '@angular/core';
import {Group} from '../groups/model/group.model';
import {ActivatedRoute} from '@angular/router';
import {WorkerService} from '../services/worker.service';
import {Location} from '@angular/common';
import {GroupsService} from '../services/groups.service';

@Component({
  selector: 'app-group-detail',
  templateUrl: './group-detail.component.html',
  styleUrls: ['./group-detail.component.css']
})
export class GroupDetailComponent implements OnInit {

  group : Group | undefined;

  constructor(private route: ActivatedRoute,
              private groupService: GroupsService,
              private location: Location) { }

  ngOnInit(): void {
    this.initGroup();
  }

  private initGroup() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.groupService.getGroupById(id.toString())
      .subscribe(group => {
        this.group = group;
      });
  }

  goBack() {
    this.location.back();
  }
}
