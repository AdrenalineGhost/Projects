let fs = require("fs"); // oude stijl modules

let data = fs.readFileSync('data.txt');

console.log(data.toString());
console.log("Program Ended");

fs.readFile('data.txt', function (err, data) {
    if (err) return console.error(err);
    console.log(data.toString());
});

console.log("Program Ended");
