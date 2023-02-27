import Point3D from "./point3D.js";

export default class Plane {
    /* plane with all points (x,y,z) for which ax+by+cz = d */
    constructor(a, b, c, d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    distanceToPoint(pt) {
        return this.a * pt.x + this.b * pt.y + this.c * pt.z - this.d;
    }

    contains(pt) {
        return this.distanceToPoint(pt) == 0;
    }

    isParallelWith(face) {
        let p = face.corners[0]
        let q = face.corners[1]
        let r = face.corners[2]
        let vect1 = new Point3D(p.x - q.x, p.y - q.y, p.z - q.z)
        let vect2 = new Point3D(p.x - r.x, p.y - r.y, p.z - r.z)
        return this.a * vect1.x + this.b * vect1.y + this.c * vect1.z == 0
            && this.a * vect2.x + this.b * vect2.y + this.c * vect2.z == 0
    }
}