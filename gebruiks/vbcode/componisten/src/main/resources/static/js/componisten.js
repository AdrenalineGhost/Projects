// JSON parsen om informatie componisten op te halen
function parseMessages(componisten) {
    maakTabelLeeg();
    if (componisten !== undefined) {
        for (let componist of componisten) {
            appendComposer(componist);
        }
    }
}

function maakTabelLeeg() {      
    let tabel = document.getElementById("suggesties");
    tabel.textContent = ""; // tabel met mogelijkheden leeg maken
}

// een rij toevoegen aan de de tabel met mogelijke componisten
function appendComposer(componist) {
    // link maken
    let link = document.createElement("a");
    link.setAttribute("href", "toon?id=" + componist["id"]);
    link.setAttribute("class", "popupItem");
    let tekst = document.createTextNode(componist["firstName"] + " "
        + componist["lastName"]);
    link.appendChild(tekst);
    // cel opvullen met link naar componist
    let cel = document.createElement("td");
    cel.setAttribute("class", "popupCell");
    cel.appendChild(link);
    // rij toevoegen aan tabel
    let rij = document.createElement("tr");
    rij.appendChild(cel);
    let tabel = document.getElementById("suggesties");
    tabel.appendChild(rij);
}

function vulAan() {
    let naam = document.getElementById("naam_componist");
    let params = new URLSearchParams({letters: naam.value});
    let url = new URL("http://localhost:8080/vulaan");
    url.search = params;
    fetch(url).then(response => response.json()).then(parseMessages)
            .catch(error => console.log(error));
}


function getElementY(element) { // verticale positie bepalen

    let targetTop = 0;

    if (element.offsetParent) {
        while (element.offsetParent) {
            targetTop += element.offsetTop; // coordinaat relatief tov ouder
            element = element.offsetParent;
        }
    } else if (element.y) {
        targetTop += element.y;
    }
    return targetTop;
}

function init() {    
    // listener voor tekstvak
    tekstvakComponist = document.getElementById("naam_componist");
    tekstvakComponist.addEventListener("keyup", vulAan);
    
    // positie tabel bepalen op basis van positie rij
    completeTable = document.getElementById("suggesties");
    autoRow = document.getElementById("suggestie_kolom");
    completeTable.style.top = getElementY(autoRow) + "px";
}

init();