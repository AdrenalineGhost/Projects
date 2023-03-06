import {stockAlphabet, stockAlphabetWithNullValues} from "./stock.js";
import {Plot} from "./plot.js";
const {map, filter} = rxjs.operators;
const {Observable} = rxjs;
const DOLARTOEURO = 0.94;

window.onload = function () {
    let plot1 = new Plot("Dolar");
    stockAlphabet
        .pipe(map(x=>[new Date(x[0]), x[1]]))
        .subscribe(x=>plot1.plotData(x));

    let plot2 = new Plot("Euro");
    stockAlphabet
        .pipe(map(x=>[new Date(x[0]), x[1]*DOLARTOEURO]))
        .subscribe(x=>plot2.plotData(x));

    let plot3 = new Plot("null(in dolar)");
    stockAlphabetWithNullValues
        .pipe(
            filter(x=>x[0]!=null),
            filter(x=>x[1]!=null),
            map(x=>[new Date(x[0]), x[1]])
        ).subscribe(x=>plot3.plotData(x))


}



