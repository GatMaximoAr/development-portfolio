import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcordeonSkilsProyectosComponent } from './acordeon-skils-proyectos.component';

describe('AcordeonSkilsProyectosComponent', () => {
  let component: AcordeonSkilsProyectosComponent;
  let fixture: ComponentFixture<AcordeonSkilsProyectosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AcordeonSkilsProyectosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AcordeonSkilsProyectosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
