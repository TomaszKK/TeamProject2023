
export class Event{
  id?: number;
 // type: string;
  name: string;
  description: string;
  date: Date;

  startTime: string;
  endTime: string;
  place: string;
  category: string;
  // isRepeated: Boolean;
 // isActive: Boolean;

  constructor(type: string, name:string, description:string, date:Date,startTime:string, endTime:string, place:string, category:string, isActive:Boolean) {
  //this.type = type;
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
