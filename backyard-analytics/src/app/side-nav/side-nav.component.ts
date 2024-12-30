import { Component } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { LineGraphComponent } from "../line-graph/line-graph.component";
import { GpsSpeedComponent } from "../gps-speed/gps-speed.component";
import { LiveTrackerComponent } from "../live-tracker/live-tracker.component";
import { ControlPlaneComponent } from "../control-plane/control-plane.component";

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatSidenavModule, LineGraphComponent, GpsSpeedComponent, LiveTrackerComponent, ControlPlaneComponent],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {

}
