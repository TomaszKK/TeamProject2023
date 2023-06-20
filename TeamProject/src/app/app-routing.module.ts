import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import {CalanderComponent} from "./calander/calander.component";
import {CompanyComponent} from "./company/company.component";
import {ActivityComponent} from "./activity/activity.component";
import {EventListComponent} from "./event-list/event-list.component";


const routes: Routes = [
  {path: 'calender', component: CalanderComponent},
  {path: 'company', component: CompanyComponent},
  {path: 'addActivity', component: ActivityComponent},
  {path: 'eventsList', component: EventListComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
