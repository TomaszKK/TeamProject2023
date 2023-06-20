import { Component, OnInit,ViewChild  } from '@angular/core';
import {EventService} from "../event.service";
import {Event} from "../event.model";
import { NgForm } from '@angular/forms';
import {Router} from "@angular/router";

// interface Event {
//   title: string;
//   date: string;
//   startHour: string;
//   endHour: string;
// }
@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent {
  @ViewChild('form') form: NgForm | undefined;

  weekDates: Date[];
  events: Event[];
  currentWeekStartDate: Date;
  hours: string[];

  constructor(private eventService: EventService,  private router: Router) {
    this.currentWeekStartDate = new Date();
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
    this.events = [];
    this.hours = this.generateHours();
  }

  private getWeekDates(startDate: Date): Date[] {
    const dayOfWeek = startDate.getDay();
    const startOfWeek = new Date(startDate.getFullYear(), startDate.getMonth(), startDate.getDate() - dayOfWeek);
    const weekDates: Date[] = [];

    for (let i = 0; i < 7; i++) {
      const date = new Date(startOfWeek.getFullYear(), startOfWeek.getMonth(), startOfWeek.getDate() + i);
      weekDates.push(date);
    }

    return weekDates;
  }

  private generateHours(): string[] {
    const hours: string[] = [];
    for (let i = 0; i < 24; i++) {
      const formattedHour = ('0' + i).slice(-2) + ':00';
      hours.push(formattedHour);
    }
    return hours;
  }

  addEvent(name: string, date: Date, description: string,place:string, category:string ,startTime: string, endTime: string) {
      let type = "EVENT"
      let active = true;
      this.eventService.add({type, name,  description,date, startTime, endTime, place, category, active} as Event)
        .subscribe({
          next: (event: Event) => {
            if (this.events != undefined) {

            }
          },
          error: () => {
          },
          complete: () => {
            if (this.events != undefined) {
              this.eventService.totalItems.next(this.events.length);
              console.log(this.events.length);
              this.router.navigate(['/calender']);
            }
          }
        })
    // @ts-ignore
    this.form.resetForm();

  }


}
