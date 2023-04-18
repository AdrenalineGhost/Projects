import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OverviewComponent } from './overview/overview.component'
import { TemperatureComponent } from './temperature/temperature.component';
import { EnergyComponent } from './energy/energy.component';
import { SecurityComponent } from './security/security.component';
import { NotifDetailComponent } from './notif-detail/notif-detail.component';

const routes: Routes = [
  { path: 'overview', component: OverviewComponent },
  { path: 'temperature', component: TemperatureComponent },
  { path: 'energy', component: EnergyComponent },
  { path: 'security', component: SecurityComponent },
  { path: 'notification/:id', component: NotifDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
