/*
run in terminal
npm install enumify

https://stackoverflow.com/questions/30710550/node-js-npm-modules-installed-but-command-not-recognized
*/

import RubiksCube from "./rubiksCube.js"
import Cube from "./cube.js"
import Direction from "./direction.js"
import Face from "./face.js"
import Plane from "./plane.js"
import Point2D from "./point2D.js"
import Point3D from "./point3D.js"


alert("we starten");
let rubik = new RubiksCube();
//console.log(rubik);


let str = "3D\n"
for (let face of rubik.getAllFaces3D()) {
    str += `\n${face}`
}
alert(str)

str = "2D\n"
for (let face of rubik.getAllFaces2D()) {
    str += `\n${face}`
}
alert(str)

