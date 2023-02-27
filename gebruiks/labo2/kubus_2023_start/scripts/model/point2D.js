import Point3D from './point3D.js'

export default class Point2D {


    PROJECTION_ANGLE = 45 / 180.0 * Math.PI; // laat 45 staan; als dat hier aangepast wordt,
                                             // moet ook planeVisibility in Direction aangepast worden

    constructor(pt3D) {
        let x = pt3D.x
        let y = pt3D.y
        let z = pt3D.z
        this.x = x + (z * Math.cos(this.PROJECTION_ANGLE))*Math.cos(this.PROJECTION_ANGLE)
        this.y = y - (z * Math.sin(this.PROJECTION_ANGLE))*Math.cos(this.PROJECTION_ANGLE)
    }

    toString() {
        return `((${this.x},${this.y}))`
    }
}