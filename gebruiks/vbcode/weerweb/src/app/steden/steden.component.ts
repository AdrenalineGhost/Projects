import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-steden',
  templateUrl: './steden.component.html',
  styleUrls: ['./steden.component.css']
})
export class StedenComponent implements OnInit {

  @Input()
  steden: string[] = [];
  selectedStad: string | undefined;
  @Output() stadChanged = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
    this.selecteerStad();
  }

  ngOnChanges(changes: SimpleChanges) {
    this.selecteerStad();
  }

  veranderd(): void {
    this.stadChanged.emit(this.selectedStad);
  }

  selecteerStad(): void {
    if (this.steden !== []) {
      this.selectedStad = this.steden[0];
      this.veranderd();
    }

  }
}
