import { Component } from '@angular/core';
import {EventService} from "../event.service";
import {Event} from "../event.model";

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent {

  events?: Event[];

  constructor(private eventService: EventService) {
  }

  ngOnInit() {
    this.eventService.getEvents().subscribe(
      (events) => {
        this.events = events;
        console.log(events);
      }
    )
  }

}
