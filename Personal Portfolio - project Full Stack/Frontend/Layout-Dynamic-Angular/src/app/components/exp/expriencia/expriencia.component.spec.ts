import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExprienciaComponent } from './expriencia.component';

describe('ExprienciaComponent', () => {
  let component: ExprienciaComponent;
  let fixture: ComponentFixture<ExprienciaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExprienciaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExprienciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
