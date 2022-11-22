import {Component, Input, OnInit} from '@angular/core';
import {Worker} from '../workers/model/worker.model';

@Component({
  selector: 'app-group-workers',
  templateUrl: './group-workers.component.html',
  styleUrls: ['./group-workers.component.css']
})
export class GroupWorkersComponent implements OnInit {

  @Input() workers : Worker[] = [];
  constructor() { }

  ngOnInit(): void {
  }

}
