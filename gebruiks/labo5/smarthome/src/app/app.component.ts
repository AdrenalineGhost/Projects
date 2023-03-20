import { Component } from '@angular/core';
import * as jsonData from '../assets/notifications.json';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'smarthome';
  jsonData = jsonData;
}
