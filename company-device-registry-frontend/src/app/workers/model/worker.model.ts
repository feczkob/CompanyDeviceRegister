import {Device} from './device.model';

export class Worker {
  public workerId:number;
  public name:string;
  public groupId:number;
  public details:string;
  public devices:Device[];

  constructor(workerId: number, name: string, groupId: number, details: string, devices: Device[]) {
    this.workerId = workerId;
    this.name = name;
    this.groupId = groupId;
    this.details = details;
    this.devices = devices;
  }
}
