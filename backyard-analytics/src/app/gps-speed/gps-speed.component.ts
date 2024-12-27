import { Component, AfterViewInit, Inject, PLATFORM_ID, signal } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { MyService } from '../my-service.service';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-gps-speed',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './gps-speed.component.html',
  styleUrl: './gps-speed.component.scss',
})
export class GpsSpeedComponent implements AfterViewInit {
  private intervalId: any;
  errorMessage: string | null = null;
  speed: any = "x";
  isBrowser = signal(false);

  constructor(private myService: MyService, @Inject(PLATFORM_ID) platformId: object) {
    this.isBrowser.set(isPlatformBrowser(platformId));
    console.log("Hello " + this.speed + "Platform" + this.isBrowser);
  }

  sendPostRequest() {
    const payload = ["gps-1"]; // Replace with your payload
    
    this.myService.postData(payload).subscribe({
      next: (data) => {
        console.log(data)
        this.speed = data[0]["data"]["speedKPH"];
        this.errorMessage = null;
      },
      error:
      (error) => {
        this.errorMessage = 'An error occurred!';
        console.error(error);
      }
    });
  }

  ngAfterViewInit() {
    console.log('View is initialized');
    this.startContinuousRequests();
  }

  startContinuousRequests() {
    if (this.isBrowser()) {
      console.log("is browser")
      this.intervalId = setInterval(() => this.sendPostRequest(), 250); // Every 100 ms
    }
  }
}
