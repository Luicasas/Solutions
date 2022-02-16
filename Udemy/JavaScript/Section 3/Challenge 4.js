'use strict';

const calculateTip = (billValue) => {
    return billValue >= 50 && billValue <= 300 ? billValue * 0.15 : billValue * 0.2;
}

const calculateAverage = (arr) => {
    let sum = 0;
    for (let i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum / arr.length;
}

const bills = [22, 295, 176, 440, 37, 105, 10, 1100, 86, 52];
const tips = [];
const totals = [];

for (let i = 0; i < bills.length; i++) {
    tips[i] = calculateTip(bills[i]);
    totals[i] = tips[i] + bills[i];
}

let values = "";
totals.forEach(element => {
    if (element !== totals[totals.length - 1]) {
        values += element + ", ";
    } else {
        values += element;
    }
});

console.log(`total = ${values}`);
console.log(`average = ${calculateAverage(totals)}`)
