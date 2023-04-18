import {Component, OnInit} from '@angular/core';
import {Land} from "./data/land";
import {LandenService} from "./data/landen.service";
import {Weer} from "./data/weer";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'weerweb';
  landen: Land[] = [];
  land: Land | undefined;
  steden: string[] = [];
  nietgevonden = false;
  weer: Weer | undefined;
  stad: string | undefined;
  tekst: string | undefined;


  constructor(private landenService: LandenService) {
  }

  veranderLand(land: Land) {
    this.land = land;
    this.landenService.haalSteden(land).subscribe(steden => this.steden = steden);
  }

  ngOnInit(): void {
    this.landenService.landen.subscribe((landen) => {
      this.landen = landen;
      this.land = landen[0];
      this.landenService.haalSteden(this.land).subscribe(steden => this.steden = steden);
    })
  }

  toonWeer(stad: string): void {
    this.landenService.haalWeer(stad).subscribe(weer => this.weer = weer);
    this.stad = stad;
  }


  toonClick(event: Event): void {
    this.tekst = event.toString();
  }
}
