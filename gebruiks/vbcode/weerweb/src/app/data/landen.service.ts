import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable, tap} from "rxjs";
import {Land} from "./land";
import {RestCountry} from "./rest-country";
import {Weer} from "./weer";
import {RestWeer} from "./rest-weer";

@Injectable({
  providedIn: 'root'
})
export class LandenService {

  private landenURL = 'https://restcountries.com/v3.1/region/europe';
  private stedenURL = 'https://restcountries.com/v3.1/alpha/';
  private key = '';
  private weerURL = 'http://api.openweathermap.org/data/2.5/forecast/daily?q=';
  private opties = '&units=metric&appid=';

  constructor(private http: HttpClient) {
  }


  get landen(): Observable<Land[]> {
    return this.http.get<RestCountry[]>(this.landenURL).pipe(
      tap(_ => console.log('fetched landen')),
      map(items => items.map(item => new Land(item.cca2, item.name.common, item.capital[0])))
    );
  }

  haalSteden(land: Land): Observable<string[]> {
    return this.http.get<RestCountry[]>(this.stedenURL + land.code)
      .pipe(
        tap(_ => console.log('fetched steden')),
        map(items => items.map(country => country.capital[0]))
      );
  }

  haalWeer(stad: string): Observable<Weer> {
    return this.http.get<RestWeer>(this.weerURL + stad + this.opties + this.key).pipe(
      tap(_ => console.log('fetched weer')),
      map(antwoord => {
        let datum: string;
        datum = (antwoord.list[0].dt * 1000).toString();
        let temperatuur: number;
        temperatuur = antwoord.list[0].temp.day;
        let vochtigheid: number;
        vochtigheid = antwoord.list[0].humidity;
        let bewolkt: number;
        bewolkt = antwoord.list[0].clouds;
        let omschrijving: string;
        omschrijving = antwoord.list[0].weather[0].description;
        let afbeelding: string;
        afbeelding = `http://openweathermap.org/img/w/${antwoord.list[0].weather[0].icon}.png`;
        let weer: Weer;
        weer = new Weer(datum, temperatuur, vochtigheid, bewolkt, omschrijving, afbeelding);
        return weer;
      })
    );
  }


}
