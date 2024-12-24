import { Component } from '@angular/core';
import {MatSidenavModule} from '@angular/material/sidenav';
import { LineGraphComponent } from "../line-graph/line-graph.component";

@Component({
  selector: 'app-side-nav',
  standalone: true,
  imports: [MatSidenavModule, LineGraphComponent],
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.scss'
})
export class SideNavComponent {

}
