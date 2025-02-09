import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSlideToggleModule, MatSlideToggleChange } from '@angular/material/slide-toggle';
import { MyService } from '../my-service.service';

@Component({
  selector: 'app-control-plane',
  standalone: true,
  imports: [MatSlideToggleModule, MatButtonModule],
  templateUrl: './control-plane.component.html',
  styleUrl: './control-plane.component.scss'
})
export class ControlPlaneComponent {
  // private theService: MyService;
  connectionBtnColor: string = '#424242';
  constructor(private myService: MyService) {
    // this.theService = myService;
  }
  toggleState: boolean = false;

  onToggleConnect() {
    console.log(this.connectionBtnColor)
    this.connectionBtnColor = this.connectionBtnColor == '#424242' ? 'red' : '#424242'
  }

  onToggleRecord() {
    console.log("click")
  }

  startStreaming() {
    console.log("starting...")
  }

  endStreaming() {
    console.log("...ending")
  }
}
