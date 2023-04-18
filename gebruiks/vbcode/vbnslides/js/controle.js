function init() {
    let invoerGegevens = document.getElementById("invoerGegevens");
    invoerGegevens.onsubmit = controleer_invoer;
}

function controleer_invoer() {
    let verder = false;
    let invoerGegevens =
            document.getElementById("invoerGegevens");
    if (invoerGegevens.naam.value === "") {
        window.alert("Naam invoeren!");
    } else {
        verder = true;
    }
    return verder;
}


init();





