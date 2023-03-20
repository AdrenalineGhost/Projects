import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent{
  @Input() icon: string|undefined;
  @Input() boodschap: string|undefined;
  timestamp = new Date();
}
