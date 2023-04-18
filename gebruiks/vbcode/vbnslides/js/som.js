function init() {
    // events aan tekstvakken
    let getal1 = document.getElementById("getal1");
    let getal2 = document.getElementById("getal2");
    getal1.onchange=berekenSom;
    getal2.onchange=berekenSom;
}

function berekenSom() {
    let getal1 = document.getElementById("getal1");
    let getal2 = document.getElementById("getal2");
    let som = parseInt(getal1.value) + parseInt(getal2.value);
    let somTekst = document.getElementById("som");
    somTekst.value = som;   
}

init();

