import { Component } from '@angular/core';
import jsonData from 'src/assets/notifications.json';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'smarthome';
  public jsonData = jsonData;
}
