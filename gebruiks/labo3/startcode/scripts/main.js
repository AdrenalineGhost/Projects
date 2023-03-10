import {stockAlphabet, stockAlphabetWithNullValues} from "./stock.js";
import {Plot} from "./plot.js";
//import * as rxjs from "rxjs";
var Rx = require('rx');
const DOLARTOEURO = 0.94;

window.onload = function () {

    currency = document.getElementById("currency");
    stock = document.getElementById("stock");
    currencyOb = Observable.fromEvent(currency, "click");
    currencyOb.subscribe(
        (event)=>console.log(event)
    )

}



