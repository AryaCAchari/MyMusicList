import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable} from 'rxjs';
import { map} from 'rxjs/operators';

@Injectable({
    providedIn: "root",
})

export class HttpClientService {

    baseUrl: string = "http://localhost:8080/music/";

    constructor(
        private http: HttpClient,
        private router: Router) { }

    postService(url: string, params: object): Observable<any> {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        return this.http.post<any>(this.baseUrl + url, params, { headers: headers })
            .pipe(map(data => {
                return data;
            }))
    }

    getService(url: string): Observable<any> {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        return this.http.get<any>(this.baseUrl + url, { headers: headers })
            .pipe(
                map(data => {
                    return data;
                }))
    }

    deleteService(url: string): Observable<any> {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        return this.http.delete<any>(this.baseUrl + url, { headers: headers })
            .pipe(
                map(data => {
                    return data;
                }))
    }
}