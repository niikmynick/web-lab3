import {drawPreview, drawNewPoint, safePreDraw, safeNewDraw} from "./src/main/webapp/script/drawer";
import {getXValues} from "./src/main/webapp/script/utils";

let input_R = document.getElementById('hitInfo:r-value_input')
let increaseButton_R = document.getElementById('hitInfo:r-value-increase')
let decreaseButton_R = document.getElementById('hitInfo:r-value-decrease')

let input_Y = document.getElementById('hitInfo:y-value')

let input_X = document.getElementById('choiceX')

let submitButton = document.getElementById('hitInfo:tryHit')

let svg = document.getElementById("graphSVG");
let svgInitData = document.getElementById("graphSVG").innerHTML;
let svgLastData = document.getElementById("graphSVG").innerHTML;

let dataTableDiv = document.getElementById('results-div')
let mouseOnTable = false

let clearDiv = document.getElementById('clearDiv')
let isClearing = false

let clickedRow = undefined;


if (document.getElementsByClassName('clickable-row').length !== 0) {
    clearDiv.style.display = 'block'
    dataTableDiv.style.padding = '20px 20px 0 20px'
}

increaseButton_R.addEventListener('click', () => {
    let xValues = getXValues()
    safePreDraw(xValues, input_Y.value, input_R.value)
});

decreaseButton_R.addEventListener('click', () => {
    let xValues = getXValues()
    safePreDraw(xValues, input_Y.value, input_R.value)
});

input_Y.addEventListener("input", function() {
    let xValues = getXValues()
    safePreDraw(xValues, input_Y.value, input_R.value)
});

input_X.addEventListener("click", function() {
    let xValues = getXValues()
    safePreDraw(xValues, input_Y.value, input_R.value)
});

svg.addEventListener('click', function (event) {

    let hiddenSubmitButton = document.getElementById('hitInfoHidden:tryHitHidden')
    let hiddenX = document.getElementById('hitInfoHidden:x-value-hidden')
    let hiddenY = document.getElementById('hitInfoHidden:y-value-hidden')
    let hiddenR = document.getElementById('hitInfoHidden:r-value-hidden')

    let r = input_R.value
    let x = (event.offsetX - 200) / (100 / r)
    let y = (event.offsetY - 200) / (-100 / r)

    safeNewDraw([x], y, r)

    hiddenX.value = x
    hiddenY.value = y
    hiddenR.value = r

    hiddenSubmitButton.click()

    svgLastData = svg.innerHTML

    clearDiv.style.display = 'block'
    dataTableDiv.style.padding = '20px 20px 0 20px'
    isClearing = false
});

submitButton.addEventListener('click', () => {
    let xValues = getXValues()
    safeNewDraw(xValues, input_Y.value, input_R.value)
    svgLastData = svg.innerHTML

    clearDiv.style.display = 'block'
    dataTableDiv.style.padding = '20px 20px 0 20px'
    isClearing = false
})

dataTableDiv.addEventListener('click', function (event) {
    let target = event.target
    if (target.tagName === 'TD') {

        clickedRow = target

        let x = parseFloat(target.parentNode.childNodes[1].innerText)
        let y = parseFloat(target.parentNode.childNodes[3].innerText)
        let r = parseFloat(target.parentNode.childNodes[5].innerText)

        if (isNaN(x) || isNaN(y) || isNaN(r) || isClearing) {
            return
        }

        target.parentNode.style.backgroundColor = '#c8e1ff'

        if (!mouseOnTable) {
            svgLastData = svg.innerHTML
            mouseOnTable = true
            svg.innerHTML = svgInitData
            drawNewPoint(x, y, r)
        } else {
            drawNewPoint(x, y, r)
        }
    }
})

dataTableDiv.addEventListener('dblclick', function (event) {
    let target = event.target

    if (target.tagName === 'TD') {
        clearSelection()
    }
})

clearDiv.addEventListener('click', function () {
    isClearing = true
    svg.innerHTML = svgInitData
    svgLastData = svgInitData

    clearDiv.style.display = 'none'
    dataTableDiv.style.padding = '20px'
})

function clearSelection() {
    for (let i of document.getElementsByClassName('clickable-row')) {
        i.style.backgroundColor = '#f9f9f9'
    }

    svg.innerHTML = svgLastData
    mouseOnTable = false

    clickedRow = undefined
}