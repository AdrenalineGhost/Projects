import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { LandenComponent } from './landen/landen.component';

import {LandenService} from './data/landen.service';
import { StedenComponent } from './steden/steden.component';
import { WeerinfoComponent } from './weerinfo/weerinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    LandenComponent,
    StedenComponent,
    WeerinfoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LandenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
