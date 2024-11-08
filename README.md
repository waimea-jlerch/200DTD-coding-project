# Ancient Gold Coin: Your Shot to Wealth

### Level 2 Programming Project by Jess Lerch

This project is assessed against [AS91896](https://www.nzqa.govt.nz/nqfdocs/ncea-resource/achievements/2019/as91896.pdf)

## Project Description

The project involves the programming of a two-player game that is based off of 
a game called 'Old Gold' that was introduced to me via physical paper board game.

- Little introduction story to 'Ancient Gold Coin: Your Shot to Wealth':

Imagine a scenario where you just lost your job and are really in need of a lot of money, an amount that would
turn your life around forever without the need to worry about finance again. You recently found a very old looking map
in your grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.
As this is your chance to change your life around, you think it is worth the risk to follow that map and find
what it is hiding... After a long struggle, in a cave, you manage to find what seemed to be the treasure that the map is
leading you to, an 'Ancient Gold Coin'. However, there's always a catch.
A silhouette slowly appears which seems to be your opponent! Watch out, both of you now have to compete and prove yourself
to the cave that you are worthy to receive the coin! This is your last shot to wealth, and you must win this!

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


## Source Code

The project is written in [Kotlin](https://kotlinlang.org/)

The main source file is [Main.kt](src/Main.kt)


## Documentation

Evidence of testing can be found in [testing.md](testing.md)


## Running the Program

You can either clone this whole repo, open it using [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and run from source; or you can run the compiled program:

1. Install the [Java runtime (JRE)](https://www.java.com/en/download/) installed to run the program.
2. Go to the [out/artifacts](out/artifacts) folder
3. Locate and download the compiled **JAR file** (e.g. FILENAME.jar)
4. Run the following command:
    ```bash
    java -jar FILENAME.jar
    ```
