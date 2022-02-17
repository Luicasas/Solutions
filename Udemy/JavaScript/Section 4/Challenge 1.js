"use strict";

const printForeCast = (array) => {
    let result = "";
    for (let i = 0; i < array.length; i++) {
        array[i] !== array[array.length - 1]
            ? result += `${array[i]}C in ${(i + 1)} days ... `
            : result += `${array[i]}C in ${(i + 1)} days.`
    }
    console.log(result);
}

let forecast = [17, 21, 23];
printForeCast(forecast);
forecast = [12, 5, -5, 0, 4];
printForeCast(forecast);
