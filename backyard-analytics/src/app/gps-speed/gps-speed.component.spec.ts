import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GpsSpeedComponent } from './gps-speed.component';

describe('GpsSpeedComponent', () => {
  let component: GpsSpeedComponent;
  let fixture: ComponentFixture<GpsSpeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GpsSpeedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GpsSpeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
