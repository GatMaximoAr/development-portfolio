import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddItemEduComponent } from './add-item-edu.component';

describe('AddItemEduComponent', () => {
  let component: AddItemEduComponent;
  let fixture: ComponentFixture<AddItemEduComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddItemEduComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddItemEduComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
