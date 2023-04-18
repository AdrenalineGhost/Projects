export default function () {

    let x = 0;
    let timer = setInterval(tekenCirkel, 100);

    function tekenCirkel() {
        // x verhogen
        x = x + 1;
        // cirkel op canvas
        let c = document.getElementById("myCanvas");
        let cxt = c.getContext("2d");
        cxt.clearRect(0, 0, 200, 100);
        cxt.fillStyle = "#FF0000";
        cxt.beginPath();
        cxt.arc(x, 18, 15, 0, Math.PI * 2, true);
        cxt.closePath();
        cxt.fill();
        if (x >= 200) {
            clearInterval(timer);
        }
        //svg-cirkel
        let cirkel = document.getElementById("cirkel");
        cirkel.setAttribute("cx", x);
    }
}
