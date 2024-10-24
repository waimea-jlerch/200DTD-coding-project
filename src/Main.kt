/**
 * ------------------------------------------------------------------------
 * Ancient Gold Coin: Your Shot to Wealthiness
 * Level 2 programming project
 *
 * by Jess Lerch
 *
 * This Game is a recreation of a game called 'Old Gold' that was introduced to me via physical paper board game.
 *
 * Little introduction story to 'Ancient Gold Coin: Your Shot to Wealthiness':
 *
 * Imagine a scenario where you just lost your job and are really in need of a lot of money, an amount that would
 * turn your life around forever without the need to worry about finance again. You recently found a very old looking map
 * in your grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.
 * As this is your chance to change your life around, you think it is worth the risk to follow that map and find
 * what it is hiding... After a long struggle, in a cave, you manage to find what seemed to be the treasure that the map is
 * leading you to, an 'Ancient Gold Coin'. However, there's always a catch.
 * A silhouette slowly appear which seem to be your opponent! Watch out, both of you now have to compete and prove yourself
 * to the cave that you are worthy to receive the coin! This is your last shot to wealthiness, and you must win this!
 *
 * The way of proving yourself to the cave and how to win (rules):
 * This game is a two player game played on a one-dimensional grid of squares. A certain number coins are randomly
 * placed onto the grid. Most of the coins are normal coin that are worthless except for one of the coins that is the
 * one and only 'Ancient Gold Coin'. Players will take turns to play. Each turn consists of only 1 move.
 * The available moves that a player can do are:
 * 1) Slide any coin any number of spaces to the *left* on a condition that:
 *      - Other coins are not jumped
 *      - It does not share the same square with another coin
 * 2) Remove a coin when it is placed/moved to the most-left grid / in position 1
 *
 * To win, you have to be the first to successfully removed the 'Ancient Gold Coin'!
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */
val silverCoin = "●".grey()
val goldCoin = "●".yellow()
val space = " "


fun main() {
    // Welcome message
    println("Welcome to 'Ancient Gold Coin' the Game!")
    println()

    val players = mutableListOf<String>()
    val grid = mutableListOf<String>()

    while (true) {
    // Get action choice from user
    val option = getUserAction()
        when (option) {
            'P' -> {
                getNames(players)
                startIntro(players)     // start with introduction
                setupGame(grid)
                playGame(grid)
            }
            'R' -> rules()                   // view rules
            'Q' -> break                     // Exit
        }
    }

}

/**
 * Get User Action from Menu
 * Displays a list of options and then gets
 * the user's choice. Returns just the first
 * character in uppercase
 */
fun getUserAction(): Char {
    while(true) {
        // Show options
        println("MENU")
        println(" [P] Play!")
        println(" [R] View Rules")
        println(" [Q] Quit")
        print("Option: ")

        // Get user choice
        val option = readln()

        if (option.isNotEmpty()) {
            // Return just the first char
            return option.uppercase().first()
        }
    }
}

fun startIntro(players: MutableList<String>) {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    val player1 : String = players[0]
    val player2 : String = players[1]

    println("Imagine a scenario where $player1 just lost their job and they are really in need of a lot of money, an amount that would\n" +
            "turn $player1's life around forever without the need to worry about finance again. $player1 recently found a very old looking map\n" +
            "in their grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.\n" +
            "As this is $player1's chance to change your life around, they think it is worth the risk to follow that map and find\n" +
            "what it is hiding... After a long struggle, in a cave, $player1 manage to find what seemed to be the treasure that the map is\n" +
            "leading you to, the 'Ancient Gold Coin'. However, there's always a catch. A silhouette slowly appear which seem to be $player2!\n" +
            "Watch out, both of you now have to compete and prove yourself to the cave that you are worthy to receive the coin!\n" +
            "This is your last shot to wealthiness, and you must win this!")

    println()
    print("Press Enter to continue...")
    readln()
}

/** skip intro */
fun getNames(players: MutableList<String>) {

    println()
    println("Enter players name")
    print("Player 1 : ")
    val player1 : String = readln()
    players.add(player1)
    print("Player 2 : ")
    val player2 : String = readln()
    players.add(player2)
}

/** View Rules! */
fun rules() {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    println("The way of proving yourself to the cave and how to win (rules):\n" +
            "This game is a two player game played on a one-dimensional grid of squares. A certain number coins are randomly\n" +
            "placed onto the grid. Most of the coins are normal coin that are worthless except for one of the coins that is the\n" +
            "one and only 'Ancient Gold Coin'. Players will take turns to play. Each turn consists of only 1 move.\n" +
            "The available moves that a player can do are:\n" +
            "1) Slide any coin any number of spaces to the *left* on a condition that:\n" +
            "      - Other coins are not jumped\n" +
            "      - It does not share the same square with another coin\n" +
            "2) Remove a coin when it is placed/moved to the most-left grid / in position 1\n" +
            "\n" +
            "To win, you have to be the first to successfully removed the 'Ancient Gold Coin'!")

    println()
    print("Press Enter to return...")
    readln()
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

}

/** grid and coin selector  */
fun setupGame(grid: MutableList<String>) {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    var gridSize: Int = 0
    var coinsNumber: Int = 0

    while(true) {
        println("Select your cave!")
        println("Note: Recommended Cave is 'THE Cave'!")
        println()

        // option 1
        print("[1] SMALL Cave (12 squares & 5 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin ")
        println()
        // option 2
        print("[2] THE Cave   (20 squares & 6 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin")
        println()
        // option 3
        print("[3] BIG Cave   (25 squares & 8 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin")
        println()

        print("Option: ")
        val caveOption: Int = readln().toInt()

        when (caveOption) {
            1 -> {
                gridSize = 12
                coinsNumber = 5
                break
            }

            2 -> {
                gridSize = 20
                coinsNumber = 6
                break
            }

            3 -> {
                gridSize = 25
                coinsNumber = 8
                break
            }
            //this only check for Int but not String!!!!
            else -> {
                println("That cave does not exist!")
            }
        }
    }

    // Build the grid
    for (i in 0 until gridSize) {
        grid.add(space)
    }

    // Silver coins
    for (i in 0 until coinsNumber - 1) {
        val position = (1 until gridSize).random()
        grid[position] = silverCoin
    }

    // Gold coin
    val position = (1 until gridSize).random()
    grid[position] = goldCoin

    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()
}

fun showCave(grid: MutableList<String>) {
    // Build Top (first line)
    print("┌")
    print("───────┬".repeat(grid.size))
    println("┐")

    for (square in grid) {

        print("|   $square   ")
    }
    println()
}

fun playGame(grid: MutableList<String>) {
    showCave(grid)
}

//    println("[2] THE Cave (20 squares & 6 coins):")
//    println("┌──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┬──────┐\n" +
//            "│      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │      │\n" +
//            "└──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┴──────┘\n" +
//            "│  1   │   2  │   3  │   4  │   5  │   6  │   7  │   8  │   9  │  10  │  11  │  12  │  13  │  14  │  15  │  16  │  17  │  18  │  19  │  20  │")
