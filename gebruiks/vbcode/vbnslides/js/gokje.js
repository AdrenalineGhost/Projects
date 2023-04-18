export default function () {
    let gokken = "Uw gokken: ";

    let knopLogUit = document.getElementById("loguit");
    knopLogUit.onclick = bevestigUitloggen;
    let gokKnop = document.getElementById("gok");
    gokKnop.onclick = gok;

    function bevestigUitloggen() {
        let uitloggen = confirm("Zeker dat je wil uitloggen?");
        return uitloggen;
    }

    function gok() {
        let gokje = prompt("Gokje?");
        if (gokje !== null && gokje !== "") {
            gokken += " " + gokje;
            document.getElementById("overzicht").value = gokken;
        } else {
            alert("Geen gok ingevuld!");
        }
    }
}
