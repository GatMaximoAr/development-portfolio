import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaAddComponent } from './acerca-add.component';

describe('AcercaAddComponent', () => {
  let component: AcercaAddComponent;
  let fixture: ComponentFixture<AcercaAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcercaAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
