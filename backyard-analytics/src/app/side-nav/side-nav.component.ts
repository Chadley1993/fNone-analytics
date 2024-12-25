import { Component } from '@angular/core';
import {MatSidenavModule} from '@angular/material/sidenav';
import { LineGraphComponent } from "../line-graph/line-graph.component";
import { GpsSpeedComponent } from "../gps-speed/gps-speed.component";

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatSidenavModule, LineGraphComponent, GpsSpeedComponent],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {

}
