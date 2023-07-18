import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateItemEduComponent } from './update-item-edu.component';

describe('UpdateItemEduComponent', () => {
  let component: UpdateItemEduComponent;
  let fixture: ComponentFixture<UpdateItemEduComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateItemEduComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateItemEduComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
