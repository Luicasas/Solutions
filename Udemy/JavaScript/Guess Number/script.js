"use strict";
// Generate random number
const NUMBER_GENERATOR = () => {
    return Math.trunc((Math.random() * 20) + 1);
}

// Run when play wins
const PLAYER_WIN = () => {
    wonStatus = true;
    if (currentScore > currentHighScore) {
        currentHighScore = currentScore;
    }
    UPDATE_SCORE();
    MESSAGE.textContent = "You won! Hit Again! to play more!";
    document.body.style.backgroundColor = '#1aff00';
    DISPLAY_NUMBER.textContent = numberToGuess.toString();
}

// Update score
const UPDATE_SCORE = () => {
    SCORE_DISPLAY.textContent = currentScore.toString();
    HIGH_SCORE_DISPLAY.textContent = currentHighScore.toString();
}

// Again! button function
const RETRY_EVENT = () => {
    numberToGuess = NUMBER_GENERATOR();
    document.body.style.backgroundColor = '#222';
    DISPLAY_NUMBER.textContent = '?';
    UPDATE_SCORE();
    wonStatus = false;
}

// Core game values
const PLAYERS_GUESS = document.querySelector('.guess');
let numberToGuess = NUMBER_GENERATOR();
let currentScore = 20;
let currentHighScore = 0;
let wonStatus = false;

// Event variables
const CHECK_BUTTON = document.querySelector('.check');
const AGAIN_BUTTON = document.querySelector('.again');

// HTML functionality variables
const MESSAGE = document.querySelector('.message');
const SCORE_DISPLAY = document.querySelector('.score');
const HIGH_SCORE_DISPLAY = document.querySelector('.highscore');
const DISPLAY_NUMBER = document.querySelector('.number');

// Check (try) button event listener
CHECK_BUTTON.addEventListener('click', function () {
    console.log(numberToGuess);
    if (currentScore > 1) {
        if (!wonStatus) {
            if (PLAYERS_GUESS.value) {
                if (Number(PLAYERS_GUESS.value) === numberToGuess) {
                    PLAYER_WIN();
                } else if (Number(PLAYERS_GUESS.value) < numberToGuess) {
                    currentScore--;
                    MESSAGE.textContent = 'A little too low...';
                    UPDATE_SCORE();
                } else {
                    currentScore--;
                    MESSAGE.textContent = 'A little too high...';
                    UPDATE_SCORE();
                }
            } else {
                MESSAGE.textContent = 'You must enter a number.';
            }
        }
    } else {
        MESSAGE.textContent = 'You already lost! Click the again button to continue.';
    }
});

// Calls retry function when clicking Again!
AGAIN_BUTTON.addEventListener('click', function () {
    RETRY_EVENT();
});
