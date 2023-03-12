import { stockAlphabet, stockAlphabetWithNullValues, stockMeta, stockTesla } from "./stock.js";
import { Plot } from "./plot.js";
const {map, filter } = rxjs.operators;
const { Observable, fromEvent } = rxjs;

const stockmap = new Map([
    ["dolar" , 0.94],
    ["euro" , 1],
    ["pound" , 0.88]
]);
const currencymap = new Map([
    ["tesla" , stockTesla],
    ["meta" , stockMeta],
    ["alpha" , stockAlphabet]
]);


let currentStock = stockAlphabet;
let currentCurrency = 1;

window.onload = function () {
    let plot = new Plot("Stock value");

    rxjs.fromEvent(document.getElementById("top-level-container"), "click")
        .pipe(()=>{
            console.log(currentStock);
            console.log(currentCurrency);
            currentStock.pipe(
                map(x=>[new Date(x[0]), x[1] * currentCurrency]
            )).subscribe(x=>plot.plotData(x));
        })
    currentStock.pipe(
        map(x=>[new Date(x[0]), x[1] * currentCurrency]
    )).subscribe(x=>plot.plotData(x));


    currency = document.getElementById("currency");
    stock = document.getElementById("stock");

    currency = rxjs.fromEvent(currency, "click");
    currency.subscribe(event=>{
        currentCurrency = currencymap.get(event.target.value);
    })

    stock = rxjs.fromEvent(stock, "click");
    stock.subscribe((event)=>{
        currentStock = stockmap.get(event.target.value);
    })


}



