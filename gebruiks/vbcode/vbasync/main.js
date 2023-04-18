function doubleAfter2Seconds(x) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(x * 2);
        }, 2000);
    });
}

function addPromise(x) {
    return new Promise(resolve => {
        doubleAfter2Seconds(10).then((a) => {
            doubleAfter2Seconds(20).then((b) => {
                doubleAfter2Seconds(30).then((c) => {
                    resolve(x + a + b + c);
                });
            });
        });
    });
}

async function addAsync(x) {
    const a = await doubleAfter2Seconds(10);
    const b = await doubleAfter2Seconds(20);
    const c = await doubleAfter2Seconds(30);
    return x + a + b + c;
}

doubleAfter2Seconds(10).then((r) => {
    console.log(r);
});
console.log("na oproep doubleAfter2Seconds");

addPromise(10).then((sum) => {
    console.log("Met promises",sum);
});
console.log("na oproep addPromise");

addAsync(10).then((sum) => {
    console.log("Met asynchrone functie", sum);
});
console.log("na oproep addAsync");

