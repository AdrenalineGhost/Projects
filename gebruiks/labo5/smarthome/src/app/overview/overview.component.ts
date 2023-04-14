import { Component } from '@angular/core';
import jsonData from 'src/assets/notifications.json'

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent {
  public jsonData = jsonData;
}
