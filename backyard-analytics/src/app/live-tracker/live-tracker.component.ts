import { Component, OnInit, ElementRef } from '@angular/core';
import * as d3 from 'd3';

@Component({
  selector: 'app-live-tracker',
  standalone: true,
  imports: [],
  templateUrl: './live-tracker.component.html',
  styleUrl: './live-tracker.component.scss'
})
export class LiveTrackerComponent implements OnInit {
  constructor(private elRef: ElementRef) {}

  ngOnInit(): void {
    this.drawPolygon();
  }

  drawPolygon(): void {
    const points: Iterable<[number, number]> = [
      [50, 150],
      [150, 50],
      [250, 80],
      [200, 200],
      [100, 250],
    ]; // Define your irregular polygon points

    const svg = d3.select(this.elRef.nativeElement.querySelector('#polygon-container'));
    
    const lineGenerator = d3.line()
      .x(d => d[0])
      .y(d => d[1])
      .curve(d3.curveLinear)

    const pathData = lineGenerator(points);

    svg
      .append('path')
      .attr('d', pathData)
      .attr('fill', 'none')
      .attr('stroke', 'darkblue')
      .attr('stroke-width', 2);
  }
}
