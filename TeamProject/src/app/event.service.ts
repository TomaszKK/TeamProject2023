import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from "@angular/common/http";
import {BehaviorSubject, catchError, Observable, of, tap} from "rxjs";
import {Event} from "./event.model";


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}
@Injectable({
  providedIn: 'root'
})
export class EventService {
  private eventUrl = 'http://localhost:8080/event';

  constructor(private http: HttpClient) { }
  
  getEvents():Observable<Event[]>{
    return this.http.get<Event[]>(this.eventUrl);
  }
  getEvent(id: number):Observable<Event>{
    const url = `${this.eventUrl}/${id}`;
    return this.http.get<Event>(url).pipe(
      tap(_ => this.log(`fetched event id=${id}`)),
      catchError(this.handleError<Event>(`getEvent id=${id}`))
    );
  }

  updateEvent(event: Event, id:number): Observable<Event> {
    window.location.reload()
    return this.http.put<Event>(`${this.eventUrl}/${id}`, event, httpOptions).pipe(
      tap(_ => this.log(`updated event id=${event.id}`)), 
      catchError(this.handleError<any>('updateEvent'))
    );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  private log(message: string) {
    console.log('EventService: ' + message);
  }
}
