function vulLijst() {
    let lijst = document.getElementById("keuzeDag");
    let dagen = ["maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"];
    for (let dag of dagen) {
        let optie = document.createElement("option");
        optie.appendChild(document.createTextNode(dag));
        lijst.appendChild(optie);                    
    }
}






