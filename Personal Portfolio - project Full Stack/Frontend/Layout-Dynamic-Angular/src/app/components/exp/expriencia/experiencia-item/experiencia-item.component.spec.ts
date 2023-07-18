import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperienciaItemComponent } from './experiencia-item.component';

describe('ExperienciaItemComponent', () => {
  let component: ExperienciaItemComponent;
  let fixture: ComponentFixture<ExperienciaItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExperienciaItemComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExperienciaItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
