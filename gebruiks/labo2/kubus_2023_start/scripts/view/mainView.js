/** @type {HTMLCanvasElement} */
import "../model/rubiksCube.js";
import RubiksCube from "../model/rubiksCube.js";
import "../model/point2D.js"
import Point2D from "../model/point2D.js";
import Direction from "../model/direction.js"

// ELEMENTS
let canvas_element = document.getElementById("canvas")
let rotation_form = document.getElementById("buttonform")
let full_rotation_form = document.getElementById("rotateform")

// INIT CANVAS
let canvas = canvas_element.getContext("2d")

// CONSTANTS
const xAlignment = 400
const yAlignment = 300
const scale = 30
const dir = new Map([
    ["D", Direction.YPOS],
    ["U", Direction.YNEG],
    ["R", Direction.XPOS],
    ["L", Direction.XNEG],
    ["B", Direction.ZPOS],
    ["F", Direction.ZNEG],
    ["Dp", Direction.YPOS],
    ["Up", Direction.YNEG],
    ["Rp", Direction.XPOS],
    ["Lp", Direction.XNEG],
    ["Bp", Direction.ZPOS],
    ["Fp", Direction.ZNEG]
])
const fulldir = new Map([
    ["x", Direction.XPOS],
    ["y", Direction.YPOS],
    ["z", Direction.ZPOS]
])

// MAIN FUNCTION
let rk = new RubiksCube()
load_rk()

// EVENTHANDLERS
rotation_form.addEventListener("click", (event)=>{
    event.target.type=="button" ? turn(event.target.id ,event.target.id[1]=="p"?false:true) : {}
})
full_rotation_form.addEventListener("click", (event)=>{
    event.target.type=="button" ? full_turn(event.target.id) : {}
})

// FUNCTIONS
/**
 * Draws the faces given onto the canvas
 * @param {face} faces Faces that should be drawn
 */
function load_rk(faces=rk.getAllFaces3D()){
    canvas.clearRect(0,0,canvas_element.width,canvas_element.height)
    faces.forEach((x)=>{
        canvas.beginPath()
        x.corners.map((x)=>{
            return new Point2D(x)
        }).forEach((x, index)=>{
            index!=0 ? canvas.lineTo(x.x *scale +xAlignment, x.y *scale +yAlignment) : canvas.moveTo(x.x *scale +xAlignment, x.y *scale +yAlignment)
        })
        canvas.closePath()
        canvas.fillStyle = x.color
        canvas.fill()
        canvas.stroke()
    })
}

/**
 * Turns specific face
 * @param {direction} dire Side to be turned
 * @param {boolean} counter Clockwise or counter
 */
function turn(dire, counter=true){
    console.log(dire)
    animate(dire, counter).then(()=>{
        sleep(45*20+10)
        rk.rotate(dir.get(dire), counter)
        load_rk()
    })
}

/**
 * Rotates the entire cube
 * @param {direction} dire Rotation to be made
 */
function full_turn(dire){
    console.log(dire)
    rk.turnAll(fulldir.get(dire))
    load_rk()
}

/**
 * Brings the python sleep function to js
 * @param {int} milliseconds Amount to sleep for
 */
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}


/**
 * Animates the rotation of a turn around a given axis
 * @param {direction} dire Axis of rotation
 * @param {boolean} counter clockwise or counter ckockwise
 */
async function animate(dire, counter){
    let factor = counter?-1:1
    for (let index = 0; index < 90; index++){
        await setTimeout(()=>{
            load_rk(rk.getAllFaces3DDuringRotation(dir.get(dire), index * factor))
        }, 20)
    }
}