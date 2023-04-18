function haalComponist() {
    let aanvraag = new XMLHttpRequest();
    if (aanvraag !== null) {
        aanvraag.open("GET",
            "http://localhost:8080/componist?naam="+haalNaam(), true);
        aanvraag.onreadystatechange = () => ontvang(aanvraag); // uit te voeren functie bij antwoord
        aanvraag.send(null); // geen corpus
    }
}

function haalNaam() {
    let componistInvoer = document.getElementById("componist");
    return componistInvoer.value;
}

function ontvang(req) {
    let bericht = document.getElementById("resultaat");
    let tekst;
    if (req.readyState === 4 && req.status === 200) { // aanvraag gelukt
        tekst = document.createTextNode(req.responseText);// info ophalen
    } else {
        tekst = document.createTextNode("Nog geen antwoord van de server");
    }
    bericht.appendChild(tekst);
    bericht.appendChild(document.createElement("br"));
}

function init() {
    let knop = document.getElementById("knop");
    knop.onclick=haalComponist;
}

init();