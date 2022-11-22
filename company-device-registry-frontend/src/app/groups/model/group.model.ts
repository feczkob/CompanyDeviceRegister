import {Worker} from '../../workers/model/worker.model';

export class Group {
  public groupId:number;
  public departmentId:number;
  public name:string;
  public description:string;
  public workers:Worker[];

  constructor(groupId: number, departmentId: number, name: string, description: string, workers: Worker[]) {
    this.groupId = groupId;
    this.departmentId = departmentId;
    this.name = name;
    this.description = description;
    this.workers = workers;
  }
}
