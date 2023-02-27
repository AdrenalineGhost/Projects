import Rotation from './rotation.js'
import Plane from './plane.js'

// ligging van het assenkruis
//
//                     ^  Z (naar achter)
//                    /
//                   /______   X (naar rechts)
//                   |
//                   |
//                   Y  (naar onder)

export default class Direction {
    static XPOS = new Direction("xpos", 1, 0, 0, 2, 0, 1, 1.9, 0, [[1, 0, 0], [0, 0, -1], [0, 1, 0]], 1, 0, 0, "green")
    static YPOS = new Direction("ypos", 0, 1, 0, 2, 1, 0, -1.9, 0, [[0, 0, 1], [0, 1, 0], [-1, 0, 0]], 0, 1, 0, "yellow")
    static ZPOS = new Direction("zpos", 0, 0, 1, 2, -1, 1, 0, 0, [[0, -1, 0], [1, 0, 0], [0, 0, 1]], 0, 0, 1, "red",)
    static XNEG = new Direction("xneg", 1, 0, 0, -2, 0, 1, 1.9, 0, [[1, 0, 0], [0, 0, 1], [0, -1, 0]], -1, 0, 0, "blue")
    static YNEG = new Direction("yneg", 0, 1, 0, -2, 1, 0, -1.9, 0, [[0, 0, -1], [0, 1, 0], [1, 0, 0]], 0, -1, 0, "white")
    static ZNEG = new Direction("zneg", 0, 0, 1, -2, -1, 1, 0, 0, [[0, 1, 0], [-1, 0, 0], [0, 0, 1]], 0, 0, -1, "orange")

    static map = new Map([
        ["green", this.XPOS],
        ["yellow", this.YPOS],
        ["red", this.ZPOS],
        ["blue", this.XNEG],
        ["white", this.YNEG],
        ["orange", this.ZNEG]
    ])


    static getDirection(color) {
        return this.map.get(color)
    }

    constructor(name, a, b, c, d, aa, bb, cc, dd, matrixCounterClockwise, fie, theta, psi, color) {
        this.name = name
        this.plane = new Plane(a, b, c, d)
        this.planeShift = new Plane(a, b, c, d / 2) // het vlak waar de zwarte vlakjes van kubussen langs elkaar heen schuiven
        this.planeVisibility = new Plane(aa, bb, cc, dd) // kijk naar afstand van center van draaiende kubus tot dit vlak, om tekenvolgorde te bepalen
        this.rotationCounterClockwise = new Rotation(matrixCounterClockwise)
        this.rotationClockwise = this.computeRotationClockwise(matrixCounterClockwise)
        this.color = color
        this.fie = fie
        this.theta = theta
        this.psi = psi

    }

    toString() {
        return this.name;
    }

    computeRotationClockwise(matrixCounterClockwise) {
        let matrixClockwise = [[0, 0, 0], [0, 0, 0], [0, 0, 0]];
        for (let i = 0; i < 3; i++) {
            for (let k = 0; k < 3; k++) {
                matrixClockwise[i][k] = -matrixCounterClockwise[i][k];
            }
        }
        matrixClockwise[0][0] *= -1;
        matrixClockwise[1][1] *= -1;
        matrixClockwise[2][2] *= -1;
        return new Rotation(matrixClockwise);
    }

    getRotation(degree) {
        // we vermenigvuldigen met this.fie/theta/psi om 'clockwise' bij negatieve as
        // goed te krijgen (moet in omgekeerde richting draaien dan bij positieve as)
        if (this.fie != 0) {
            return new Rotation(this.fie * degree, 0, 0)
        } else if (this.theta != 0) {
            return new Rotation(0, this.theta * degree, 0)
        } else if (this.psi != 0) {
            return new Rotation(0, 0, this.psi * degree)
        }
    }
}
