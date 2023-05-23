import { Component } from '@angular/core';
import {EventInt} from '../event-int'
import {EVENTLIST} from '../mock-events';
@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {
  events = EVENTLIST;

}
