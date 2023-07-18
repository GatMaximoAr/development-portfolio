import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EducacionItemComponent } from './educacion-item.component';

describe('EducacionItemComponent', () => {
  let component: EducacionItemComponent;
  let fixture: ComponentFixture<EducacionItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EducacionItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EducacionItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
