export default class Rotation {

    // slechts 1 constructor mogelijk in JavaScript,
    // daarom omweg via undefined
    // één parameter: dan moet daar een matrix staan
    // drie parameters: dan moeten daar de drie hoeken fie,theta,psi staan
    // https://en.wikipedia.org/wiki/Rotation_formalisms_in_three_dimensions
    constructor(fie, theta, psi) {
        if (theta != undefined && psi != undefined) {
            fie = fie / 180.0 * Math.PI
            theta = theta / 180.0 * Math.PI
            psi = psi / 180.0 * Math.PI
            let a = Math.cos(theta) * Math.cos(psi)
            let b = -Math.cos(fie) * Math.sin(psi) + Math.sin(fie) * Math.sin(theta) * Math.cos(psi)
            let c = Math.sin(fie) * Math.sin(psi) + Math.cos(fie) * Math.sin(theta) * Math.cos(psi)
            let d = Math.cos(theta) * Math.sin(psi)
            let e = Math.cos(fie) * Math.cos(psi) + Math.sin(fie) * Math.sin(theta) * Math.sin(psi)
            let f = -Math.sin(fie) * Math.cos(psi) + Math.cos(fie) * Math.sin(theta) * Math.sin(psi)
            let g = -Math.sin(theta)
            let h = Math.sin(fie) * Math.cos(theta)
            let i = Math.cos(fie) * Math.cos(theta)
            this.matrix = [[a, b, c], [d, e, f], [g, h, i]]
        } else {
            this.matrix = fie
        }
    }
}