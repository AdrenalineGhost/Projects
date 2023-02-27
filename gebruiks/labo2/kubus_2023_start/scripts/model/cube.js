import Direction from "./direction.js"
import Face from "./face.js"
import Plane from "./plane.js"
import Point3D from "./point3D.js"

export default class Cube {

    static totalNumberOfBlack = 0

    static delta = [
        [-1, -1, 1],
        [-1, 1, 1],
        [1, 1, 1],
        [1, -1, 1],
        [1, -1, -1],
        [1, 1, -1],
        [-1, 1, -1],
        [-1, -1, -1]];

// Merk op: de bovenstaande hoekpunten werden in een specifieke volgorde opgesomd.
// Als de hoekpunten in die volgorde overlopen worden en dus aan vlakken toegekend worden,
// dan zullen ze altijd in wijzer- of tegenwijzerzin toegevoegd worden - maar nooit 'kriskras'.
//                      $**********
//                    /         / *
//                   ***********  *
//                   *         *  *
//                   *         *  *
//                   *         * *
//                   @---------*
// Start bij @, volg de sterretjes, en voeg elk hoekpunt dat je tegenkomt in die volgorde toe.
// Als je bij $ uitkomt voeg je nog het achterste, onzichtbare punt toe.

    static cornersOfFace = [
        [2, 3, 4, 5],
        [1, 2, 5, 6],
        [0, 1, 2, 3],
        [0, 1, 6, 7],
        [0, 3, 4, 7],
        [4, 5, 6, 7]];

    constructor(x, y, z, origineleCube) {
        if(origineleCube === undefined) {
            this.center = new Point3D(x, y, z)
            this.corners = this.fillCorners()
            this.colorsFaces = this.fillColors()
        }
        else{ // diepe kopie maken; kleuren worden nooit gewijzigd dus dat mag blijven
            this.center = new Point3D(origineleCube.center.x,origineleCube.center.y,origineleCube.center.z)
            this.corners = this.deepcopyCorners(origineleCube.corners)
            this.colorsFaces = origineleCube.colorsFaces
        }
    }

    fillCorners() {
        let corners = [];
        for (let i = 0; i < 8; i++) {
            corners[i] = new Point3D(Cube.delta[i][0] + this.center.x, Cube.delta[i][1] + this.center.y, Cube.delta[i][2] + this.center.z);
        }
        return corners;
    }

    fillColors() {
        let colors = [];
        let directions = [Direction.XPOS, Direction.YPOS, Direction.ZPOS, Direction.XNEG, Direction.YNEG, Direction.ZNEG];
        for (let direction of directions) {
            if(direction.plane.contains(this.center)) {
                colors.push(direction.color)
            } else {
                colors.push("black");
            }
        }
        return colors;
    }

    deepcopyCorners(cornersOld){
        let cornersNew = []
        for(let corner of cornersOld){
            cornersNew.push(new Point3D(corner.x,corner.y,corner.z))
        }
        return cornersNew
    }

    // zullen gesorteerd weergegeven worden
    getAllFaces3D(direction) {
        let plane = new Plane(1,-1,-1,2)

        let faces = []
        for (let i = 0; i < 6; i++) {
            faces[i] = new Face(this.colorsFaces[i],
                this.corners[Cube.cornersOfFace[i][0]],
                this.corners[Cube.cornersOfFace[i][1]],
                this.corners[Cube.cornersOfFace[i][2]],
                this.corners[Cube.cornersOfFace[i][3]]);
        }
        faces.sort(function(a,b){
            let dist_a = plane.distanceToPoint(a.getMiddle())
            let dist_b = plane.distanceToPoint(b.getMiddle())
            return dist_a - dist_b
        })
        return faces;
    }
    getAllFaces3DDuringRotation(direction,degree){
        let rotation = direction.getRotation(degree)
        let kopie = new Cube(0,0,0,this) // diepe kopie van Cube
        kopie.rotateSmallAmount(direction,degree)
        return kopie.getAllFaces3D(direction)
    }

    rotateSmallAmount(direction,degree){
        let rotation = direction.getRotation(degree)
        for(let corner of this.corners){ // toch te doen met read-only for-loop!
            corner.rotate(rotation)
        }
    }

    rotate(direction,clockwise){
        let rotation = direction.rotationClockwise;
        if(!clockwise){
            rotation = direction.rotationCounterClockwise;
        }
        for(let corner of this.corners){
            corner.rotate(rotation)
        }
        this.center.rotate(rotation)
    }

    distanceOfFurthestPoint(plane){
        let dist_max = plane.distanceToPoint(this.corners[0])
        for(let i=1; i<8; i++){
            let dist_i = plane.distanceToPoint(this.corners[i])
            if(dist_i > dist_max){
                dist_max = dist_i
            }
        }
        return dist_max
    }

    toString() {
        let str = "";
        let k = 0;
        for (let pt of this.corners) {
            if(k%4 == 0){
                str += "\n";
            }
            str += `(${pt.x}, ${pt.y}, ${pt.z})`
            k++;
        }
        str += "\n"
        for (let face of this.getAllFaces()) {
            str += ` ${face.color}`
        }
        return str;
    }

}