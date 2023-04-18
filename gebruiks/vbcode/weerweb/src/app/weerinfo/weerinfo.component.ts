import {Component, Input, OnInit} from '@angular/core';
import {Weer} from "../data/weer";

@Component({
  selector: 'app-weerinfo',
  templateUrl: './weerinfo.component.html',
  styleUrls: ['./weerinfo.component.css']
})
export class WeerinfoComponent implements OnInit {

  @Input() weer: Weer | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
