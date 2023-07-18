import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaUpdateComponent } from './acerca-update.component';

describe('AcercaUpdateComponent', () => {
  let component: AcercaUpdateComponent;
  let fixture: ComponentFixture<AcercaUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcercaUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcercaUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
