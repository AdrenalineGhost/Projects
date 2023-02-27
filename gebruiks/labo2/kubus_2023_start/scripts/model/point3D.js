export default class Point3D{


    constructor(x,y,z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    toString(){
        return `(${this.x.toFixed(3)},${this.y.toFixed(3)},${this.z.toFixed(3)})`
    }

    rotate(rotation){
        let pt = this.getRotatedCopy(rotation)
        this.x = pt.x
        this.y = pt.y
        this.z = pt.z
    }

    getRotatedCopy(rotation){
        let result = [0,0,0]
        let original = [this.x,this.y,this.z]
        let matrix = rotation.matrix
        for(let i=0; i<3; i++){
            for(let k=0; k<3; k++){
                result[i] += matrix[i][k]*original[k]
            }
        }
        return new Point3D(result[0],result[1],result[2])
    }
}