
let radio = document.getElementsByName("taal");
let drop = document.getElementById("prenten");
const english = new Array("brave", "home", "strength", "who");
const french = new Array("grand", "mieux", "petit");
let namedict = {
    "english":english,
    "francais":french
};

function addLang(l) {
    for (const word of l) {
        let opt = document.createElement("option");
        opt.value = word;
        opt.textContent = word;
        drop.appendChild(opt);
    }
}
function remLang(l) {
    for (let name of l){
        for (let elem of drop){
            if (elem.value==name){
                document.removeChild(elem);
            }
        }
    }
}
document.getElementById("fullradio").addEventListener(onclick, () => {
    for (let ra of document.getElementsByName("taal")) {
        ra.checked?addLang(namedict[ra.value]):remLang(namedict[ra.value=="english"?"francais":"english"])
    }
});

