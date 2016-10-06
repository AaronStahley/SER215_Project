/*
 * File:   pigGame.cpp
 * Author: CMarsh
 *
 * Created on August 24, 2016, 10:19 AM
 */

#include <cstdlib>
#include<iostream>
#include<string>
#include<ctime>

using namespace std;

int humanTurn(int humanTotalScore);//defining the "turn" functions and their input parameter
int computerTurn(int computerTotalScore);

int main() {

    int humanTotalScore = 0, computerTotalScore = 0;//initialize "turn scores" and boolean variables
    bool humanVictory = false, computerVictory = false;
    srand(time(NULL));//random seed so the dice doesn't roll the same values each game.

    cout << "Let's play a game of Pig!" << endl << endl;//Output rules to the console so the user knows how to play
    cout << "Roll a 2-6 to roll again or hold the dice and keep your points!" << endl;
    cout << "Roll a 1 and lose your turn and points for that turn immediately!" << endl;
    cout << "First player to reach 100 points after holding, wins!" << endl << endl;

    while (humanVictory == false && computerVictory == false) {//while nobody has won yet, keep the game going

        humanTotalScore += humanTurn(humanTotalScore);//add the score that was held when calling next instance of the function

        if (humanTotalScore >= 100) {//if you score over 100 points you are the winner

            humanVictory = true;

            cout << "Congratulations, you won!" << endl;//victory message and score display
            cout << "Your total score: " << humanTotalScore << endl;
            cout << "Computer total score: " << computerTotalScore << endl;

            return 0;
        }

        computerTotalScore += computerTurn(computerTotalScore);//add the computer's held score when calling the next instance of the function

        if (computerTotalScore >= 100) {//if the computer scores over 100 points accumulated, it wins

            computerVictory = true;

            cout << "You lose! Better luck next time!" << endl;//defeat message along with final score display
            cout << "Your total score: " << humanTotalScore << endl;
            cout << "Computer total score: " << computerTotalScore << endl;

            return 0;
        }
    }
}

int rollTheDice() {//this function simulates the rolling of dice by randomly selecting a number between 1-6

    return (rand() % 6) + 1;
}

int humanTurn(int humanTotalScore) {//this function takes care of your turn

    int humanTurnScore = 0, diceRoll = 0;//set score for this turn to 0 and initialize a blank dice roll
    char turnChoice;//initialize variable for 'R' or 'H' (roll or hold)

    do {
        diceRoll = rollTheDice();//initialize a dice roll by calling the rollTheDice() function

        if (diceRoll == 1) {//if the dice roll is a one, end the turn and return 0 for no points

            cout << "Darn, you rolled a 1! Turn ended!" << endl << endl;

            return 0;
        }

        humanTurnScore = humanTurnScore + diceRoll;//add the dice roll to the turn score each time

        cout << "You rolled a " << diceRoll << ". So far you have " << humanTurnScore << " points this turn. " << endl << endl;//output turn score

    do {
        cout << "Roll again(R/r) or Hold (H/h)?: ";//ask to roll or hold
        cin >> turnChoice;//input 'h' for hold and 'r' for roll again
        cout << endl;

    }
    while(tolower(turnChoice) != 'r' && tolower(turnChoice) != 'h');//input validating for the roll again or hold prompt

    }
    while (tolower(turnChoice) == 'r');

    if (tolower(turnChoice) == 'h') {//if the user inputs 'h' it will hold the score and return current turn score

        return humanTurnScore;
    }
}

int computerTurn(int computerTotalScore) {//this method takes care of the computer turn

    int computerTurnScore = 0, diceRoll = 0;//initialize turn score and dice to 0

    do {//this do-while keeps the computer turn going until 1 is rolled or if the computer gets more than 20 points in a turn
        diceRoll = rollTheDice();//roll the dice

        if (diceRoll == 1) {//if one is rolled, turn ends and points are not given

            cout << "Computer rolled a 1! Turn ended!" << endl << endl;

            return 0;
        }

        computerTurnScore = computerTurnScore + diceRoll;//add the dice roll to the current turn score

        cout << "Computer rolled a " << diceRoll << ". So far it has " << computerTurnScore << " points this turn. " << endl << endl;//display current turn score
    }
    while (computerTurnScore < 20);

    if (computerTurnScore >= 20) {//if the computer gets over 20 points in one turn, it chooses to hold

        cout << "Computer holds." << endl <<endl;

        return computerTurnScore;
    }
}
