import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { EventComponent } from './event/event.component';
import { CalanderComponent } from './calander/calander.component';
import { CompanyComponent } from './company/company.component';
import {RouterOutlet, Routes} from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import {ActivityComponent} from "./activity/activity.component";
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {NgOptimizedImage} from "@angular/common";



@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    CalanderComponent,
    CompanyComponent,
    ActivityComponent
  ],
  imports: [
    // CommonModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgOptimizedImage,
    // NgbModalModule,
    // FlatpickrModule.forRoot(),
    // CalendarModule.forRoot({
    //   provide: DateAdapter,
    //   useFactory: adapterFactory,
    // }),
  ],



  providers: [/*MakeCalendarService*/],
  bootstrap: [AppComponent]
})
export class AppModule { }
