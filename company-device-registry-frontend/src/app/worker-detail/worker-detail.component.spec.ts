import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkerDetailComponent } from './worker-detail.component';

describe('WorkerDetailComponent', () => {
  let component: WorkerDetailComponent;
  let fixture: ComponentFixture<WorkerDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkerDetailComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorkerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
