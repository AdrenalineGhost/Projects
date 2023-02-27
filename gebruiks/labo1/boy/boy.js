let checkedlanguage = "fr";
let radio = document.getElementsByName("taal");
let drop = document.getElementById("prenten");
const english = new Array("brave", "home", "strength", "who");
const french = new Array("grand", "mieux", "petit");
let image = document.getElementById("prent");

// Atribute the name of the language with the dict of the language
let namedict = {
    "english":english,
    "francais":french
};

// Add language in given dropdown
function addLang(l) {
    for (const word of l) {
        let opt = document.createElement("option");
        opt.value = word;
        opt.textContent = word;
        drop.appendChild(opt);
    }
}

// Clear all children of a given parent node
function clearallchildren(parentnode){
    parentnode.innerHTML = "";
} 

// Radio buttons and dropdown 
document.getElementById("fullradio").addEventListener("click", () => {
    clearallchildren(drop);
    for (let ra of radio) {
        if (ra.checked){
            addLang(namedict[ra.value]);
            checkedlanguage = ra.id;
        }
    }
});

// Dropdown and images
document.getElementById("toon").addEventListener("click", () => {
    image.setAttribute("src","images/" + checkedlanguage + "_" + drop.value + ".jpg" )
})

