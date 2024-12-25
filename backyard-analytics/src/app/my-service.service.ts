import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MyService {
  private apiUrl = 'http://localhost:5000/data'; // Replace with your API URL

  constructor(private http: HttpClient) {}

  postData(payload: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, payload);
  }
}
