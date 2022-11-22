import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GroupWorkersComponent } from './group-workers.component';

describe('GroupWorkersComponent', () => {
  let component: GroupWorkersComponent;
  let fixture: ComponentFixture<GroupWorkersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GroupWorkersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GroupWorkersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
