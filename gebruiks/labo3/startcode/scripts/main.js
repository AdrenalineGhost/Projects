import {stockAlphabet, stockAlphabetWithNullValues} from "./stock.js";
import {Plot} from "./plot.js";
const {map, filter} = rxjs.operators;
import { from, Observable, internal, fromEvent } from "node_modules/rxjs";
const DOLARTOEURO = 0.94;

window.onload = function () {

    currency = document.getElementById("currency");
    stock = document.getElementById("stock");
    currencyOb = Observable.fromEvent(currency, "click");
    currencyOb.subscribe(
        (event)=>console.log(event)
    )

}



