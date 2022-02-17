"use strict";
// Generate random number
const randomNumber = () => {
    return Math.trunc(Math.random() * 10) + 1;
}

// Modify when player's input is lower than the random number
const lowerScore = () => {
    currentScore--;
    message.textContent = "Too low!"
    score.textContent = currentScore.toString();
}

// Modify highscore
const higherScore = () => {
    currentScore--;
    message.textContent = "Too high!";
    score.textContent = currentScore.toString();
}

// Scoring the random number (win)
const correctGuess = () => {
    if (currentScore > currentHighScore) {
        currentHighScore = currentScore;
    }
    win = true;
    message.textContent = "Correct!";
    score.textContent = currentScore.toString();
    highScore.textContent = currentHighScore;
    currentScore++;
    console.log(valueToGuess);

    // Change background color and text
    body.style.backgroundColor = '#60b347';
    number.style.width = '30rem';
    number.textContent = valueToGuess;

    valueToGuess = randomNumber();
}

const lost = () => {
    message.textContent = "You lost!";
}

const retry = () => {
    win = false;
    currentScore = 20;
    score.textContent = currentScore;
    highScore.textContent = currentHighScore;
    message.textContent = "Start guessing...";
    body.style.backgroundColor = '#222';
    number.style.width = '15rem';
    number.textContent = '?';
    guess.value = '';
}

// Variables to modify
const message = document.querySelector('.message');
const score = document.querySelector('.score');
const highScore = document.querySelector('.highscore');
const check = document.querySelector('.check');
const again = document.querySelector('.again');
const number = document.querySelector('.number');
const body = document.querySelector('body');
const guess = document.querySelector('.guess');

// Playable values
let win = false;
let valueToGuess = randomNumber();
let currentScore = 20;
let currentHighScore = currentScore;
console.log(valueToGuess);

check.addEventListener('click', function () {
    const choice = Number(document.querySelector('.guess').value);
    if (!win) {
        if (currentScore > currentHighScore) {
            currentHighScore = currentScore;
            highScore.textContent = currentHighScore;
        }
        if (!choice) {
            message.textContent = "No input :(";
        } else if (choice === valueToGuess) {
            if (currentScore > 1) {
                correctGuess();
            } else {
                lost();
            }
        } else if (choice < valueToGuess) {
            if (currentScore > 1) {
                lowerScore();
            } else {
                lost();
            }
        } else {
            if (currentScore > 1) {
                higherScore();
            } else {
                lost();
            }
        }
    } else {
        message.textContent = 'You already won! Hit the again button.';
    }
});

again.addEventListener('click', function () {
    retry();
});
