import { Component, OnInit } from '@angular/core';

interface Event {
  title: string;
  date: string;
  startHour: string;
  endHour: string;
}
@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent {

  weekDates: Date[];
  events: Event[];
  currentWeekStartDate: Date;
  hours: string[];

  constructor() {
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

  addEvent(title: string, date: string, hour: string, endHour: string) {
    const event: Event = {
      title: title,
      date: date,
      startHour: hour,
      endHour: endHour
    };
    this.events.push(event);
  }

}
