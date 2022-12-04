import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Device} from '../../workers/model/device.model';
import {DeviceService} from '../../services/device.service';

@Component({
  selector: 'app-device-dialog',
  templateUrl: './device-dialog.component.html',
  styleUrls: ['./device-dialog.component.css']
})
export class DeviceDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeviceDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Device,
              private deviceService: DeviceService) { }

  ngOnInit(): void {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  addDevice() {
    this.deviceService.addDevice(this.data)
      .subscribe();
  }
}
