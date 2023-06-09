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
  {path: 'eventsList', component: EventListComponent},
  {path: '', redirectTo: '/calender', pathMatch: 'full'},
  {path: 'addActivity', component: ActivityComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
