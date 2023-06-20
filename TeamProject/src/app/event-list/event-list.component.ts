import { Component } from '@angular/core';
import {EventService} from "../event.service";
import {Event} from "../event.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {

  events?: Event[];

  constructor(private eventService: EventService, private router: Router) {
  }

  ngOnInit() {
    this.eventService.getEvents().subscribe(
      (events) => {
        this.events = events;
        console.log(events);
      }
    )
  }

  joinEvent(event: Event) {
    event.active = true;

    // Navigate to the calendar route
    this.router.navigate(['/calendar']);
  }
  updatEvent(event: Event): void {
    event.active = true;
    let  id = event.id;
    if (id != undefined) {
      this.eventService.updateEvent(event, id)
        .subscribe({
          next: (event: Event) => {
            if (this.events != undefined) {

              this.eventService.getEvents().subscribe(events => {
                this.events = events

              });
            }
          },
          error: () => {
          },
          complete: () => {
            if (this.events != undefined) {
              this.eventService.totalItems.next(this.events.length);
              console.log(this.events.length);
            }
          }
        })
    }
  }
}
