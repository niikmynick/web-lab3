import {draw} from "./src/main/webapp/script/drawer";

// change values
// let selector_R = document.querySelector("#r-value");
// let input_Y = document.querySelector("#y-value");
//
// selector_R.addEventListener("change", function() {
//     draw(0, input_Y.value, selector_R.value);
// });
//
//
// input_Y.addEventListener("input", function() {
//     let rValues = document.querySelectorAll('.rBox');
//     let r;
//
//     rValues.forEach(checkbox => {
//         if (checkbox.checked) {
//             r = checkbox.value;
//         }
//     });
//     draw(0, input_Y.value, r);
// });


// svg listener
//
let svg = document.getElementById("graphSVG");
//
// svg.addEventListener('click', function (event) {
//
//     let rValues = document.querySelectorAll('.rBox');
//     let r;
//
//     rValues.forEach(checkbox => {
//         let flag = true
//         if (checkbox.checked && flag) {
//             r = checkbox.value;
//             flag = false
//         }
//     });
//
//     if (r !== null) {
//         let option = document.createElement('option');
//         let x = (event.offsetX - 200) / (100 / r)
//         let y = (event.offsetY - 200) / (-100 / r)
//
//         option.value = x.toString();
//         document.getElementById('x-value').appendChild(option);
//         document.getElementById('x-value').value = x;
//
//         document.getElementById('y-value').value = y;
//
//         document.getElementById('hitInfo').submit();
//     }
// });

// form listener

const submitButton = document.getElementById('hitInfo:tryHit')
submitButton.addEventListener('click', () => {
    let xValues = []
    if (document.getElementById('hitInfo:x-4').checked === true) {
        xValues.push(-4)
    }
    if (document.getElementById('hitInfo:x-3').checked === true) {
        xValues.push(-3)
    }
    if (document.getElementById('hitInfo:x-2').checked === true) {
        xValues.push(-2)
    }
    if (document.getElementById('hitInfo:x-1').checked === true) {
        xValues.push(-1)
    }
    if (document.getElementById('hitInfo:x0').checked === true) {
        xValues.push(0)
    }
    if (document.getElementById('hitInfo:x1').checked === true) {
        xValues.push(1)
    }
    if (document.getElementById('hitInfo:x2').checked === true) {
        xValues.push(2)
    }
    if (document.getElementById('hitInfo:x3').checked === true) {
        xValues.push(3)
    }
    if (document.getElementById('hitInfo:x4').checked === true) {
        xValues.push(4)
    }

    let yValue = document.getElementById('hitInfo:y-value').value
    let rValue = document.getElementById('hitInfo:r-value_input').value

    draw(xValues.at(0), yValue, rValue)

})

// let temp = document.getElementById('hitInfo:x-1')
// temp.addEventListener('click', event => {
//     console.log('click')
//     console.log(temp.checked)
// })