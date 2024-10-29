# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.
It is a game about competing to obtain the 'Ancient gold coin' before your opponent
to gain your shortcut to long-lasting wealthiness!
This game is played on a one-dimensional grid of squares.
A certain number coins are randomly placed onto the grid.
Most of the coins are normal coin that are worthless except
for one of the coins that is the one and only 'Ancient Gold Coin'.
Players will take turns move the coins from right to left.
When a coin is at the most left grid, it can be removed of the grid.
First player to remove the 'Ancient Gold Coin' wins!

### Game Features and Rules

The game has the following features and/or rules:

- The way of proving yourself to the cave and how to win (rules):

This game is a two player game played on a one-dimensional grid of squares. A certain number coins are randomly
placed onto the grid. Most of the coins are normal coin that are worthless except for one of the coins that is the
one and only 'Ancient Gold Coin'. Players will take turns to play. Each turn consists of only 1 move.
The available moves that a player can do are:
1) Slide any coin any number of spaces to the *left* on a condition that:
    - A coin cannot jump over another coin
    - It does not share the same square with another coin
2) Remove a coin when it is placed/moved to the most-left grid / in position 1

To win, you have to be the first to successfully removed the 'Ancient Gold Coin'!

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- Main Menu
- FUNCTIONALITY / FEATURE / ACTION TO TEST
- FUNCTIONALITY / FEATURE / ACTION TO TEST
- FUNCTIONALITY / FEATURE / ACTION TO TEST
- FUNCTIONALITY / FEATURE / ACTION TO TEST

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Main Menu

Main Menu should be able to withstand any invalid inputs, 
and allows player to select each option that will lead to the correct flow of programme without errors.

#### Test Data / Actions to Use

1) Try inputting invalid inputs
2) Try inputting nothing at all
3) Try inputting each option to check if it leads to the correct flow of programme.

#### Expected Outcome

1) display error message and display main menu again
2) display error message and display main menu again
3) observed what function the main menu jumps to after an option is selected.
      - [P] Play, should jump to 'startIntro()' function
      - [S] Skip, should jump to 'getNames()' function
      - [R] Rules, should jump to 'rules()' function
      - [Q] Quit, should exit the programme


### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE


### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE


### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE


---


## Evidence / Results of Testing

### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE


### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE

