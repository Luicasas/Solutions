'use strict';

const calculateTip = (billValue) => {
    return billValue >= 50 && billValue <= 300 ? billValue * 0.15 : billValue * 0.2;
}

let bills = [125, 555, 44];
let tips = [];
let total = [];

for (let i = 0; i < bills.length; i++) {
    tips[i] = calculateTip(bills[i]);
    total[i] = tips[i] + bills[i];
}

console.log(tips);
console.log(total);
