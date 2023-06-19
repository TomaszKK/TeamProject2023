enum EventCategory {
  Lecture = 'Lecture',
  Tutorial = 'Tutorial',
  Lab = 'Lab',
  Casual = 'Casual',
  SchoolEvent = 'SchoolEvent'
}
export class Event{
  id?: number;
  type: string;
  name: string;
  description: string;
  date: Date;

  startTime: string;
  endTime: string;
  place: string;
  category: EventCategory;
  // isRepeated: Boolean;
 // isActive: Boolean;

  constructor(type: string, name:string, description:string, date:Date,startTime:string, endTime:string, place:string, category:EventCategory, isActive:Boolean) {
  this.type = type;
  this.name = name;
  this.description = description;
  this.date = date;
  this.startTime = startTime;
  this.endTime = endTime;
  this.place = place;
  this.category = category;
  //this. isActive = isActive;

  }

}
