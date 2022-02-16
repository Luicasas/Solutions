'use strict';

const mark = {
    firstName: "Mark",
    lastName: "Miller",
    mass: 78,
    height: 1.69,

    calculateBMI: (weight, height) => {
        return weight / height**2;
    }
}

const john = {
    firstName: "John",
    lastName: "Smith",
    mass: 92,
    height: 1.95,

    calculateBMI: (weight, height) => {
        return weight / height**2;
    }
}

const markBMI = mark.calculateBMI(mark.mass, mark.height);
const johnBMI = john.calculateBMI(john.mass, john.height);

console.log(markBMI);
console.log(johnBMI);
