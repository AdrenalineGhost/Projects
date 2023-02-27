import Point3D from './point3D.js'

export default class Face {
    constructor(color, punt1, punt2, punt3, punt4) {
        this.color = color;
        this.corners = [punt1, punt2, punt3, punt4];
    }

    getMiddle() {
        let x = 0;
        let y = 0;
        let z = 0;
        for (let i = 0; i < 4; i++) {
            x += this.corners[i].x;
            y += this.corners[i].y;
            z += this.corners[i].z;
        }
        return new Point3D(x, y, z);
    }

    toString() {
        return `${this.color} ${this.corners[0]} ${this.corners[1]} ${this.corners[2]} ${this.corners[3]} `
    }
}