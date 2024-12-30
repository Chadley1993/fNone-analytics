import { Component } from '@angular/core';
import { MatSlideToggleModule, MatSlideToggleChange } from '@angular/material/slide-toggle';
import { MyService } from '../my-service.service';

@Component({
  selector: 'app-control-plane',
  standalone: true,
  imports: [MatSlideToggleModule],
  templateUrl: './control-plane.component.html',
  styleUrl: './control-plane.component.scss'
})
export class ControlPlaneComponent {
  // private theService: MyService;
  constructor(private myService: MyService) {
    // this.theService = myService;
  }

  onToggle(event: MatSlideToggleChange) {
    console.log('Toggle state:', event.checked);

    if (event.checked) {
      this.startStreaming();
      this.myService.startDataStream();
    } else {
      this.endStreaming();
      this.myService.stopDataStream();
    }
  }

  startStreaming() {
    console.log("starting...")
  }

  endStreaming() {
    console.log("...ending")
  }
}
