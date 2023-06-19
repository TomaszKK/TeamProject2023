import { Component, OnInit } from '@angular/core';
import {EventService} from "../event.service";
import {Event} from "../event.model";
// interface Event1 {
//   title: string;
//   date: string;
//   startHour: string;
//   endHour: string;
// }
@Component({
  selector: 'app-calander',
  templateUrl: './calander.component.html',
  styleUrls: ['./calander.component.css']
})
export class CalanderComponent implements OnInit{

  weekDates: Date[];
  events: Event[];
  currentWeekStartDate: Date;
  hours: string[];

  constructor(private eventService: EventService) {
    this.currentWeekStartDate = new Date();
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
    this.events = [];
    this.getEvents();
    this.hours = this.generateHours();
  }
  ngOnInit(){

  }
  debug(){

    console.log(this.events[0].description);

  }

  calculateEventHeight(startHour: string, endHour: string): string {
    console.log(startHour, endHour);
    console.log("look above");

    const hourHeight = 20; // Height in pixels for each hour
    const start = parseInt(startHour, 10);
    const end = parseInt(endHour, 10);
    let eventHeight = ((end - start) * hourHeight) + (end - start);
    console.log(start, end, eventHeight);
    return `${eventHeight}px`;
  }
  calculateRowSpan(startHour: string, endHour: string): number {
    const start = this.hours.indexOf(startHour);
    const end = this.hours.indexOf(endHour);
    return end - start + 1;
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
    // const event: Event = {
    //   title: title,
    //   date: date,
    //   startHour: hour,
    //   endHour: endHour
    // };

    // this.events.push(event);
  }

  getEventsForDateAndHour(date: Date, hourIndex: number): Event[] {
    //console.log("lookatme" + hourIndex);
   for(let i = 0; i< this.events.length;i++){
      this.events[i].date = new Date(this.events[i].date);
    }
   //console.log(this.events[0].startTime + ' '+ this.hours[hourIndex]);
    return this.events.filter(
      event =>
        this.isSameDate(event.date, date) &&
        event.startTime === this.hours[hourIndex] &&
        this.isHourWithinRange(event.startTime, event.endTime, this.hours[hourIndex])
    );
  }

  private parseDate(dateString: string): Date {
    const [year, month, day] = dateString.split('-');
    console .log(Number(year), Number(month), Number(day))
    return new Date(Number(year), Number(month), Number(day) );
  }

  private isSameDate(date1: Date, date2: Date): boolean {
    return (
      date1.getFullYear() === date2.getFullYear() &&
      date1.getMonth() === date2.getMonth() &&
      date1.getDate() === date2.getDate()
    );
  }

  private isHourWithinRange(startHour: string, endHour: string, currentHour: string): boolean {
    console.log("entered" + startHour + currentHour)
    return currentHour >= startHour && currentHour <= endHour;
  }

  previousWeek() {
    this.currentWeekStartDate.setDate(this.currentWeekStartDate.getDate() - 7);
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
  }

  nextWeek() {
    this.currentWeekStartDate.setDate(this.currentWeekStartDate.getDate() + 7);
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
  }
  showAddEventModal(date: Date, hour: string) {
    console.log("ever enter?");
    const formattedDate = this.formatDate(date);
    const formattedHour = hour;


    console.log('Selected Date:', formattedDate);
    console.log('Selected Hour:', formattedHour);

    const title = prompt('Enter event title:');
    // if (title) {
    //   console.log("LOOK");
    //   const event: Event = {
    //     title: title,
    //     date: formattedDate,
    //     startHour: formattedHour,
    //     endHour: formattedHour
    //   };
    //
    //   this.events.push(event);
    // }
  }

  private formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
  }
  getEvents(): void {
    this.eventService.getEvents()
      .subscribe(events => this.events = events);
  }


/*
import { Component, OnInit, ViewChild } from '@angular/core';
import {EVENTLIST} from '../mock-events';
import {EVENTLIST1} from '../mock-events';
import {EVENTLIST2} from '../mock-events';
import {EVENTLIST3} from '../mock-events';
import {EVENTLIST4} from '../mock-events';
import { NgForm } from '@angular/forms';

// import { MakeCalendarService } from '../make-calendar.service';
// import { Day } from "../day.model";
interface Event {
  title: string;
  date: string;
  startHour: string;
  startMinute: string;
  endHour: string;
  endMinute: string;
  color: string;
  textColor: string;
}
@Component({
  selector: 'app-calander',
  templateUrl: './calander.component.html',
  styleUrls: ['./calander.component.css']
})
export class CalanderComponent implements OnInit{
  @ViewChild('eventForm', { static: false }) eventForm!: NgForm;

  weekDates: Date[];
  events: Event[];
  currentWeekStartDate: Date;
  hours: string[];


  selectedDate: Date | null = null;
  showModal: boolean = false;

  startHour: number = 0; // Starting hour of the day
  endHour: number = 23; // Ending hour of the day
  minuteStep: number = 15; // Step value for minutes
  minutes: number[] = []; // Array to hold minutes for dropdown

  constructor() {
    this.currentWeekStartDate = new Date();
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
    this.events = [];
    this.hours = this.generateHours();
  }
  showAddEventModal(date: Date, startHour: string, startMinute: string, endHour: string, endMinute: string) {
    this.selectedDate = date;
    const eventForm = this.eventForm.form;

    eventForm.patchValue({
      date: this.formatDate(date),
      startHour,
      startMinute,
      endHour,
      endMinute
    });

    this.showModal = true;
  }



  // this.events.push(event);
  //   }
  // }
  calculateRowSpan(startHour: string, endHour: string): number {
    const start = this.hours.indexOf(startHour);
    const end = this.hours.indexOf(endHour);
    return end - start + 1;
  }
  private formatDate(date: Date): string {
    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);
    return `${year}-${month}-${day}`;
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
  // addEvent(event: Event) {
  //   this.events.push(event);
  // }
  addEvent(eventForm: NgForm) {
    const formData = eventForm.value;
    const startHourParts = formData.startHour.split(':');
    const endHourParts = formData.endHour.split(':');

    const event: Event = {
      title: formData.title,
      date: formData.date,
      startHour: startHourParts[0],
      startMinute: startHourParts[1],
      endHour: endHourParts[0],
      endMinute: endHourParts[1],
      color: formData.color,
      textColor: formData.textColor
    };

    this.events.push(event);
    eventForm.resetForm();
  }
  // addEvent(title: string, date: string, hour: string, endHour: string) {
  //   const event: Event = {
  //     title: title,
  //     date: date,
  //     startHour: hour,
  //     endHour: endHour
  //   };
  //
  //   this.events.push(event);
  // }

  getEventsForDateAndHour(date: Date, hourIndex: number): Event[] {
    return this.events.filter(
      event =>
        this.isSameDate(this.parseDate(event.date), date) &&
        event.startHour === this.hours[hourIndex] &&
        this.isHourWithinRange(event.startHour, event.endHour, this.hours[hourIndex])
    );
  }

  private parseDate(dateString: string): Date {
    const [year, month, day] = dateString.split('-');
    return new Date(Number(year), Number(month) - 1, Number(day));
  }

  private isSameDate(date1: Date, date2: Date): boolean {
    return (
      date1.getFullYear() === date2.getFullYear() &&
      date1.getMonth() === date2.getMonth() &&
      date1.getDate() === date2.getDate()
    );
  }

  private isHourWithinRange(startHour: string, endHour: string, currentHour: string): boolean {
    return currentHour >= startHour && currentHour <= endHour;
  }

  previousWeek() {
    this.currentWeekStartDate.setDate(this.currentWeekStartDate.getDate() - 7);
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
  }

  nextWeek() {
    this.currentWeekStartDate.setDate(this.currentWeekStartDate.getDate() + 7);
    this.weekDates = this.getWeekDates(this.currentWeekStartDate);
  }

  ngOnInit(){

    this.hours = [];
    for (let hour = this.startHour; hour <= this.endHour; hour++) {
      this.hours.push(hour.toString());
    }

    // Populate minutes dropdown
    for (let minute = 0; minute < 60; minute += this.minuteStep) {
      this.minutes.push(minute);
    }

  }
  /*

  public monthDays!: Day[];

  public monthNumber!: number;
  public year!: number;

  public weekDaysName = [];

  constructor(public calendarCreator: MakeCalendarService) {}

  ngOnInit(): void {
    this.setMonthDays(this.calendarCreator.getCurrentMonth());

    // @ts-ignore
    this.weekDaysName.push("Mo");
    // @ts-ignore
    this.weekDaysName.push("Tu");
    // @ts-ignore
    this.weekDaysName.push("We");
    // @ts-ignore
    this.weekDaysName.push("Th");
    // @ts-ignore
    this.weekDaysName.push("Fr");
    // @ts-ignore
    this.weekDaysName.push("Sa");
    // @ts-ignore
    this.weekDaysName.push("Su");
  }

  onNextMonth(): void {
    this.monthNumber++;

    if (this.monthNumber == 13) {
      this.monthNumber = 1;
      this.year++;
    }

    this.setMonthDays(this.calendarCreator.getMonth(this.monthNumber, this.year));
  }

  onPreviousMonth() : void{
    this.monthNumber--;

    if (this.monthNumber < 1) {
      this.monthNumber = 12;
      this.year--;
    }

    this.setMonthDays(this.calendarCreator.getMonth(this.monthNumber, this.year));
  }

  private setMonthDays(days: Day[]): void {
    this.monthDays = days;
    this.monthNumber = this.monthDays[0].monthIndex;
    this.year = this.monthDays[0].year;
  }

  /*
  mondayEvent = EVENTLIST;
  tuesdayEvent = EVENTLIST1;
  wednesdayEvent = EVENTLIST2
  thursdayEvent = EVENTLIST3;
  fridayEvent = EVENTLIST4;
  test = 5;



  checkStyle(holder: number, loop: number, day: number){
    let placeHolder = 'testing'+ day + loop;

    var ele = document.getElementById(placeHolder);

    if (holder ==  0 && ele != null) {
      ele.classList.add("freeTimeStyle");
    }
    if (holder ==  1 && ele != null) {
      ele.classList.add("classStyle");
    }
  }

  ngOnInit() {
  }*/
}

