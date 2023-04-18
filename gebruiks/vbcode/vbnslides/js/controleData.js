function init() {
    let invoerGegevens = document.getElementById("invoerGegevens");
    invoerGegevens.onsubmit = controleer_invoer;
}

function controleer_invoer() {
    let verder = true;
    const start = document.forms["invoerGegevens"]["startdatum"].value
    const einde = document.forms["invoerGegevens"]["einddatum"].value
    
    if (einde < start) {
        window.alert("Einde voor start!");
        verder = false;
    }
    return verder;
}


init();





