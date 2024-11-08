# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.
'Ancient Gold Coin: Your Shot to Wealth' is a game about competing to obtain the 'Ancient gold coin' before your opponent
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
- Game Setup:
  - Getting player names -> invalid detections
  - Select Cave -> invalid detection
  - Custom Cave setting -> invalid detection
  - Check cave setup/display -> correctly setup as selected cave
- Playing the Game:
  - Moving Coins
  - Invalid moves and changing turns (if a player get invalid move they still have chance to play again
  - Removing coin confirmation message when a coin that is in the most left square is selected and its corresponding response
  - Winner detected, ending story, and that the game loop works properly once a game has finished
- Playing the whole game throughout as if a user playing using it.
<!-- FUNCTIONALITY / FEATURE / ACTION TO TEST--->

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.

<!------------------------------------------------------------------------------------------------------------------>

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

<!------------------------------------------------------------------------------------------------------------------>

### Getting Players Names

The program asks for players name. It should be able to detect invalid data that would otherwise ruin the game experience.

#### Test Data / Actions to Use

1) Try inputting valid names (This could be either string and integers or both)
2) Try not inputting anything at all
3) Try inputting names that are too long

These will be tested on both player1 and player2

#### Expected Outcome

1) Names are excepted and proceed to Intro Story (Intro story will randomly select a name from the 2 players to be the main character. Name that is chosen as main character for a game loop will be displayed more frequency in the Intro Story.)
2) Program Insert default name to user that didn't enter a name
3) Error message telling that the name is too long and let them try again

<!------------------------------------------------------------------------------------------------------------------>

### Selecting Cave (grid size / coin number)

Program display options for players to select determining the number of grid size and coin number to set up. One of the options
also includes 'Custom Settings' which will be tested separately.

#### Test Data / Actions to Use

1) Try inputting invalid options such as: strings, number that are not included in the options, not inputting anything at all.
2) Select a valid option

#### Expected Outcome

1) Display error message saying that it is an invalid option
2) Set up the game and start the game by displaying the game grid (cave).

<!------------------------------------------------------------------------------------------------------------------>

### Custom Cave Settings

When the custom cave setting is selected players are allow to enter their desired number of grid and coins number for 
the program to set up. There are several limitations that is noted above when this option is selected. 

#### Test Data / Actions to Use

1)  Try breaking the limitations
- This could include: 
  - a ridiculously large grid size and coins number
  - entering coins number that is more than or equals to the grid number
  - entering a negative number
  - entering strings

2) Valid inputs
3) Entering No when confirmation message came up

#### Expected Outcome

1) Display error message corresponding to the errors detected, and let players input from the start of the custom setting again
2) Accepts, set up the game, and start the game by displaying the game grid (cave).
3) Runs again from cave selection menu

<!------------------------------------------------------------------------------------------------------------------>

### Game Set Up - Coins Placement

After selecting a cave or creating a cave from the custom settings, the program is expected to display the correct game grid
and coin number that is selected / inputted by user. The most left grid is expected to be empty when game is first set up. 
Also, Coins are expected to have the correct number with one of them being the ancient gold coin. Coins are expected to not
overlapped each other.

#### Test Data / Actions to Use

Run the program multiple times and try to set up the game to see if caves (game grid) are being display correctly. Also, try 
using custom setting and entering only 1 coin.

#### Expected Outcome

Caves (game grid) should be correctly display as selected or inputted without any coins overlapping on the same position.
There must always be 1 ancient gold coin on the cave grid therefore if only 1 coin is entered in custom settings that 1 coin must be
the ancient gold coin.

<!------------------------------------------------------------------------------------------------------------------>

### Moving coins & taking turns 

When game starts the first player to take a turn is Player1. And the program will ask the player to move a coin.
A coin can only be moved to the left and can be moved how ever much space there is to the left as long as it does not jump over another coin.

#### Test Data / Actions to Use

Making valid moves

#### Expected Outcome

Coin moved and player turn is switched.

<!------------------------------------------------------------------------------------------------------------------>

### Invalid Moves and not changing players turn

If any invalid moves is detected, turn will not be changed
and the player in turn will get to try again.

#### Test Data / Actions to Use

Try entering an invalid move or data type such as Strings. 

Invalid Moves includes:
- Moving a coin to the right
- Selected a square that has no coin and is empty
- Moving a coin to a space that is already occupied by another coin
- Selecting a grid that is out of bound
- entering a negative integer
- inputting Strings

#### Expected Outcome

Display error message corresponding to the detected error, and let player in turn go again.

<!------------------------------------------------------------------------------------------------------------------>

### Removing a coin

When a coin at the most left grid is selected a confirmation message is displayed asking if they want to remove that coin or not

#### Test Data / Actions to Use

Select a coin at the most left grid and...
1) entering [Y] to confirm for the coin to be removed
2) entering [N] to not confirm for the coin to be removed
3) entering invalid choice that is not in the option

#### Expected Outcome

1) Coin is removed and switched turns
2) Player in turn get to go again
3) Display error message and let player in turn go again

<!------------------------------------------------------------------------------------------------------------------>

### Winner Detected / Game Ending Story

When a player had removed a gold coin from the most left grid, that player has won. Programme take players to the Ending
Story and loops the whole game again until player quit the program.

#### Test Data / Actions to Use

1) Remove a gold coin
2) Check if program acknowledge the right player that wins.
3) Press 'Enter' in the ending story

#### Expected Outcome

1) Proceed to ending story
2) The name of Player that won should be display to show that they have won.
3) Loop the whole game again

<!------------------------------------------------------------------------------------------------------------------>

### Whole Game Testing

Test the whole game as if real users are using it to ensure there is no error that will break and stop the program

#### Test Data / Actions to Use

Run the game multiple times with a friend to ensure a real end user experience testing.

#### Expected Outcome

The program works without unexpected error that will break and stop the program

<!------------------------------------------------------------------------------------------------------------------

### TEST NAME HERE

TEST DESCRIPTION HERE

#### Test Data / Actions to Use

TEST DATA TO USE DETAILED HERE

#### Expected Outcome

EXPECTED OUTCOME DETAILED HERE

-->


---


## Evidence / Results of Testing

Note: Most of the testing evidence videos have 'chapters' (in microsoft Stream) with descriptions of the parts in a clip for a better marking experience.

### Main Menu

Videos below shows testing of the Main Menu

Invalid testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/ESqttIyOz5lNgbd5khqxVegB3kpWWePX0MbVIEtB5KfpuQ)

Valid testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/ER8ECBqWYnNCo9uFRU3l79gBIa5JGXMt7c7jFw6HrLqvGw?nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D&e=Jv5XeQ)

Main Menu accepts options in both uppercase and lowercase. If invalid is detected an error message is displayed.


### Getting Players Names

The video below shows how the game react to different name inputs, and how it reacts when errors are detected

Getting players names testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EQ5SSW8HD4FIpWQ6orJ94REBQkbLGLQZk5cSve0Oh0dtzA)

Notes: 
- valid names can include both integers and or strings. 
- Names cannot be too long (not more than 20 characters). 
- If name is not inputted, game will use default names.


### Selecting Cave (grid size / coin number)

The video below test the selective cave function against invalid inputs and response to valid inputs.

Selective Cave testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EdU694vyMCRApJx-pjebIqgBGNXwG0HOQa1NMYwgayVngw?e=LcSr7W)

When valid cave is selected, game will proceed to start


### Custom Cave Settings

The video below show how custom cave settings works and how it handles against invalid inputs

Custom Cave Settings testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EQP-gfQr4E1Ch5S7haeUeDUBy6LcwrYxqt7FGbfZnmaZHg?e=Umq1Z7)

When user select [N] when confirming setting, it loop back to the initial cave selection menu.


### Game Set Up - Coins placement

The video below shows how coins are correctly generated in different spots without overlapping. The most left grid always starts of empty
and 1 coin must be the ancient gold coin in every game.

Game Set Up testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EQLuVEby-llJvy9-jxvMX8YBu1J5P9re6zgx00VNpSW9UA?e=RCV8H2)

Using custom it is possible to have only 1 coin which must be the ancient gold coin as shown in the video.


### Moving coins & taking turns

The video below showcase how the game successfully moved a coin and switched players' turns back and forth.

Moving coins & taking turns testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EUP_DoMjSzlMpEysE9_s9HUBvoEOxhTkywEhZBdZI9-8eg?e=lbFa6H)

Note: This testing is checking only for valid moves


### Invalid Moves and not changing players turn

The video below shows how the game don't allow room for invalid move that would cheat rules. The game displays error message on what
user did wrong which could help user to notice and recover. When an invalid move is detected, turns will not be switched but the player
in turn will get to go again. The player will get to go again until valid move is detected.

Invalid Moves and not changing turns testing:
[Click Here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/ESFe9yCa0YFEnohwB2TC9lkB_L1li6NRimz91ktocZORgA?e=30YWiD)


### Removing a coin

The video below demonstrates when coin at the most left grid is selected. It can be removed and a confirmation
to which player can choose whether they want to remove the coin is display.


Removing a coin testing:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EYGF26BGbsNMuqSjJ7_rvw4BmteY-KovFqjrXouEGJ4P6w?e=Dd838Y)

Note: if a player select [N] no, it will keep being that player's turn until another valid move detected or a coin is successfully removed.

### Winner Detected / Game Ending Story

The video belows shows that the game is able to detect the correct winner and display player's name correctly in the ending story.
When players acknowledge that this is the ending and press 'ENTER' the game will loop itself again until the player quit the game
in the main menu.

Testing clip:
[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EQRgA1HkEdVPocV3WR0pQr8BUkbRX1GsUDUE8N4M4QBMbQ)


### Whole Game Testing

This final video shows the whole game testing done by me and a tester. We will try to play the game and see if the program is solid
and can prevent against invalids that could happen during playing.

Testing clip (This clip is quite long so speeding up the clip is recommended):

[Click here](https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/jlerch_waimea_school_nz/EQg0AuZ22hlPn_h2NbPieVkBfIesoLsrmF39sfr-PALJYw)

Note: The tester above is my schoolmate, Song Lee.


<!--
### TEST NAME HERE

ACTUAL RESULTS OF TESTING SHOWN HERE

![](images/placeholder.jpg)

NOTES REGARDING THE RESULTS HERE
--->
