const {Observable} = rxjs;

class StockSignal {
    constructor(path) {
        this.index = 0;
        fetch(path).then(response => response.json()).then(data => {
            this.data = data;
        });
    }

    // get the current price of the stock
    get value() {
        if (this.index < this.data.length - 1) {
            this.index++;
        }
        return this.data[this.index]['Value'];
    }

    // get the current date
    get date() {
        return this.data[this.index]['Date'];
    }
}

export let stockAlphabet = new Observable(subscriber => {
    let stockAlphabet = new StockSignal("data/alphabet.json");
    setInterval(() => subscriber.next([stockAlphabet.date, stockAlphabet.value]), 1000);
});

export let stockMeta = new Observable(subscriber => {
    let stockAlphabet = new StockSignal("data/alphabet.json");
    setInterval(() => subscriber.next([stockAlphabet.date, stockAlphabet.value]), 1000);
});

export let stockTesla = new Observable(subscriber => {
    let stockAlphabet = new StockSignal("data/alphabet.json");
    setInterval(() => subscriber.next([stockAlphabet.date, stockAlphabet.value]), 1000);
});



export let stockAlphabetWithNullValues = new Observable(subscriber => {
    let stockAlphabet = new StockSignal("data/alphabet_with_null_values.json");
    setInterval(() => subscriber.next([stockAlphabet.date, stockAlphabet.value]), 1000);
});
