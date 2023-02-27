import Cube from "./cube.js"
import Plane from "./plane.js"

export default class RubiksCube {


    constructor() {
        this.cubes = [];
        for (let x = -2; x <= 2; x += 2) {
            for (let y = -2; y <= 2; y += 2) {
                for (let z = -2; z <= 2; z += 2) {
                    this.cubes.push(new Cube(x, y, z));
                }
            }
        }
    }

    turnAll(direction) {
        for (let cube of this.cubes) {
            cube.rotate(direction, true) // true = clockwise
        }

    }

    // roteert één groot vlak (9 kubusjes) van de kubus in wijzerzin
    rotate(direction, clockwise) {
        for (let cube of this.cubes) {
            if (direction.plane.contains(cube.center)) {
                cube.rotate(direction, clockwise)
            }
        }
    }

    // zullen gesorteerd weergegeven worden; eerst cubes gesorteerd; binnen cubes nog 's gesorteerd
    getAllFaces3D() {
        let faces = []
        // plane = vlak door de drie punten dichtst bij het meest zichtbare pt (wat meest naar rechts, boven, voor uitsteekt)
        let plane = new Plane(1, -1, -1, 2)
        this.cubes.sort(function (a, b) {
            return plane.distanceToPoint(a.center) - plane.distanceToPoint(b.center)
        })
        for (let cube of this.cubes) {
            for (let face of cube.getAllFaces3D()) {
                faces.push(face)
            }
        }
        return faces
    }

    // zullen gesorteerd weergegeven worden; eerst cubes gesorteerd; binnen cubes nog 's gesorteerd
    getAllFaces3DDuringRotation(direction, degree) {
        let faces = []
        let rotation = direction.getRotation(degree)
        this.cubes.sort(function (a, b) {
            // sorteer eerst op afstand tot direction.plane (dan maakt rotatie nog niet uit) met andere woorden:
            //   voor rotatie om X-as teken je eerst meest linkse, dan middenste, dan rechtse laag van 9 blokjes (van vlak 'x==-2' over 'x==0' naar 'x==2')
            //   voor rotatie om Y-as teken je eerst onderste, dan middenste, dan bovenste laag van 9 blokjes (van vlak 'y==2' over 'y==0' naar 'y==-2')
            //   voor rotatie om Z-as teken je eerst achterste, dan middenste, dan voorste laag van 9 blokjes (van vlak 'z==2' over 'z==0' naar 'z==-2')
            // als dat gelijk is, wordt er gesorteerd op afstand tot direction.planeVisibility met andere woorden:
            //   voor rotatie om X-as teken je voor dezelfde 'laag' van 9 blokjes eerst wat achter het schuine vlak ligt met vgl y==-z (of zo ongeveer)
            //   voor rotatie om Y-as teken je voor dezelfde 'laag' van 9 blokjes eerst wat achter het schuine vlak ligt met vgl z==x
            //   voor rotatie om Z-as teken je voor dezelfde 'laag' van 9 blokjes eerst wat achter het schuine vlak ligt met vgl x==y

            let dist_a = direction.plane.distanceToPoint(a.center)
            let dist_b = direction.plane.distanceToPoint(b.center)
            if (dist_a == dist_b) { // dan moet je tov planeVisibility kijken
                let dist_aa
                let dist_bb
                if (dist_a == 0) { // dan behoren beide kubusjes tot de 9 die moeten draaien
                    // en moet het geroteerde centrum bekeken worden
                    dist_aa = direction.planeVisibility.distanceToPoint(a.center.getRotatedCopy(rotation))
                    dist_bb = direction.planeVisibility.distanceToPoint(b.center.getRotatedCopy(rotation))
                } else {
                    dist_aa = direction.planeVisibility.distanceToPoint(a.center)
                    dist_bb = direction.planeVisibility.distanceToPoint(b.center)
                }

                if (direction.name.includes("y")) {
                    return dist_aa - dist_bb
                }
                return dist_bb - dist_aa
            }
            if (direction.name.includes("x")) {
                return dist_a - dist_b
            }
            return dist_b - dist_a
        })
        for (let cube of this.cubes) {
            if (direction.plane.contains(cube.center)) {
                for (let face of cube.getAllFaces3DDuringRotation(direction, degree)) {
                    faces.push(face)
                }
            } else {
                //for (let face of cube.getAllFaces3D()) {
                //    faces.push(face)
                //}
                cube.getAllFaces3D().forEach(x=>faces.push(x))
            }
        }
        return faces
    }


    toString() {
        let str = "";
        for (let cube of this.cubes) {
            str += cube;
        }
        return str;
    }
}