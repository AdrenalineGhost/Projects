function haalComponist() {
    // parameters
    let params = new URLSearchParams({naam: haalNaam()});
    // POST-aanvraag
    fetch("http://localhost:8080/componist",
        {
            method: 'post',
            headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            },
            body: params
        }).then(ontvangTekst).then(response => response.text()).then(toonTekst).catch(fout);
    // GET - aanvraag
    let url = new URL("http://localhost:8080/componist")
    url.search = params
    fetch(url).then(ontvangTekst).then(response => response.text()).then(toonTekst).catch(fout);
}

function haalNaam() {
    let componistInvoer = document.getElementById("componist");
    return componistInvoer.value;
}

function ontvangTekst(response) {
    if (!response.ok) {
        throw new Error("Fout" + response.status);
    }
    // aanvraag gelukt
    return response;
}

function toonTekst(data) {
    let resultaat = document.getElementById("resultaat");
    resultaat.appendChild(document.createTextNode(data));
    resultaat.appendChild(document.createElement("br"));
}

function fout(error) {
    // aanvraag mislukt
    let resultaat = document.getElementById("resultaat");
    resultaat.appendChild(document.createTextNode(error)); // info ophalen
}

function init() {
    let knop = document.getElementById("knop");
    knop.onclick=haalComponist;
}

init();