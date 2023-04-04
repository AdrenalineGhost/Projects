import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent{
  @Input() icon: string|undefined; // This is vital for making this actually work
  @Input() boodschap: string|undefined; // without the undefined it doesnt actually work for sonme reason
  timestamp = new Date();
}
