import { Component, OnInit } from '@angular/core';
import {EVENTLIST} from '../mock-events';
import {EVENTLIST1} from '../mock-events';
import {EVENTLIST2} from '../mock-events';
import {EVENTLIST3} from '../mock-events';
import {EVENTLIST4} from '../mock-events';

@Component({
  selector: 'app-calander',
  templateUrl: './calander.component.html',
  styleUrls: ['./calander.component.css']
})
export class CalanderComponent implements OnInit{

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
  }
}
