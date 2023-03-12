import { stockAlphabet, stockAlphabetWithNullValues, stockMeta, stockTesla } from "./stock.js";
import { Plot } from "./plot.js";
const {map, filter } = rxjs.operators;
const { Observable, fromEvent } = rxjs;

const currencymap = new Map([
    ["dolar" , 0.94],
    ["euro" , 1],
    ["pound" , 0.88]
]);
const stockmap = new Map([
    ["tesla" , stockTesla],
    ["meta" , stockMeta],
    ["alpha" , stockAlphabet]
]);


let currentStock = stockAlphabet;
let currentCurrency = 1;

window.onload = function () {
    let plot = new Plot("Stock value");

    // get the required elements for checking the currency and stock value
    currency = document.getElementById("currency");
    stock = document.getElementById("stock");

    // gets the right currency when changed
    let currob = rxjs.fromEvent(currency, "click");
    currob.subscribe(event=>{
        console.log("currency changed");
        currentCurrency = currencymap.get(event.target.value);
        update(currentStock, currentCurrency, plot);
    })

    // gets the right stock when changed
    let stockob = rxjs.fromEvent(stock, "click");
    stockob.subscribe((event)=>{
        console.log("stock changed");
        currentStock = stockmap.get(event.target.value);
        update(currentStock, currentCurrency, plot);
    })

    // // try to update the canvas when any click is made
    // rxjs.fromEvent(document.getElementById("top-level-container"), "click")
    //     .pipe(()=>{
    //         console.log(currentStock);
    //         console.log(currentCurrency);
    //         currentStock.pipe(
    //             map(x=>[new Date(x[0]), x[1] * currentCurrency]
    //         )).subscribe(x=>plot.plotData(x));
    //     })

    // plot the data from the stock using the modifying value of the currency

}

function update(stock, curr, plot){
    plot = new Plot("stock value")
    stock
        .pipe(map(x=>[new Date(x[0], x[1]*curr)]))
        .subscribe(x=>plot.plotData(x));
    console.log("updated");
}


