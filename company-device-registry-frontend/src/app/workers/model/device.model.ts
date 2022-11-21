export class Device {
  public deviceId: number;
  public workerId: number;
  public name: string;
  public description: string;
  public timeOfRegistration: Date;

  constructor(deviceId: number, workerId: number, name: string, description: string, timeOfRegistration: Date) {
    this.deviceId = deviceId;
    this.workerId = workerId;
    this.name = name;
    this.description = description;
    this.timeOfRegistration = timeOfRegistration;
  }
}
