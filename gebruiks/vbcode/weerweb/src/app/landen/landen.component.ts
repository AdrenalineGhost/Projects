import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {Land} from "../data/land";

@Component({
  selector: 'app-landen',
  templateUrl: './landen.component.html',
  styleUrls: ['./landen.component.css']
})
export class LandenComponent implements OnChanges {

  selectedLand: Land | undefined;

  @Output() landChanged = new EventEmitter<Land>();

  @Input()
  landen: Land[] = [];

  constructor() {
  }

  veranderdLand(): void {
    this.landChanged.emit(this.selectedLand);
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (this.landen !== [] && this.selectedLand == undefined ){
      this.selectedLand = this.landen[0];
    }
  }

}
