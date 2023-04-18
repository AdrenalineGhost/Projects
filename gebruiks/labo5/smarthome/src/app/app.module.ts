import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotificationComponent } from './notification/notification.component';
import { TemperatureComponent } from './temperature/temperature.component';
import { EnergyComponent } from './energy/energy.component';
import { SecurityComponent } from './security/security.component';
import { OverviewComponent } from './overview/overview.component';
import { TemperatureGaugeComponent } from './temperature-gauge/temperature-gauge.component';
import { NotifDetailComponent } from './notif-detail/notif-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    NotificationComponent,
    TemperatureComponent,
    EnergyComponent,
    SecurityComponent,
    OverviewComponent,
    TemperatureGaugeComponent,
    NotifDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
