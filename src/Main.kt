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
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()
    // Welcome message
    println("Welcome to 'Ancient Gold Coin' the Game!".bold())

    val players = mutableListOf<String>()
    val grid = mutableListOf<String>()
//    val turn = arrayOf(0,1)
    var turn = 0

    while (true) {
    // Get action choice from user
    val option = getUserAction()
        when (option) {
            'P' -> {
                getNames(players)
                startIntro(players)          // start with introduction
                setupGame(grid)
                playGame(grid, players, turn)
            }
            'S' -> {
                getNames(players)
                setupGame(grid)              // start without introduction
                playGame(grid, players, turn)
            }
            'R' -> rules()                   // view rules
            'Q' -> System.exit(0)     // Exit
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
        println()

        // Show options
        println("MENU")
        println(" [P] Play!")
        println(" [S] Start without intro")
        println(" [R] View Rules")
        //credits??
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

    println("Imagine a scenario where ${players[0]} just lost their job and they are really in need of a lot of money, an amount that would\n" +
            "turn ${players[0]}'s life around forever without the need to worry about finance again. ${players[0]} recently found a very old looking map\n" +
            "in their grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.\n" +
            "As this is ${players[0]}'s chance to change your life around, they think it is worth the risk to follow that map and find\n" +
            "what it is hiding... After a long struggle, in a cave, ${players[0]} manage to find what seemed to be the treasure that the map is\n" +
            "leading you to, the 'Ancient Gold Coin'. However, there's always a catch. A silhouette slowly appear which seem to be ${players[1]}!\n" +
            "Watch out, both of you now have to compete and prove yourself to the cave that you are worthy to receive the coin!\n" +
            "This is your last shot to wealthiness, and you must win this!")

    println()
    print("Press Enter to continue...")
    readln()
}

fun getNames(players: MutableList<String>) {

    println()
    // adding player 1's name
    println("Enter players name")
    print("Player 1 : ")
    val player1 : String = readln()
    // check for empty input
    if (player1.isNotBlank() ) {
        players.add(player1)
    }
    else{
        players.add("Mr.A")
    }

    //getting player 2's name
    print("Player 2 : ")
    val player2 : String = readln()
    // check for empty input
    if (player2.isNotBlank() ) {
        players.add(player2)
    }
    else{
        players.add("Mr.B")
    }

    println()
    println("Hi Player 1, your name is ${players[0]}")
    println("             AND")
    println("Hi Player 2, your name is ${players[1]}")
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

    var gridSize: Int = 0
    var coinsNumber: Int = 0

    while(true) {
        println()
        println("Select your cave!".bold())
        println("Note: Recommended Cave is 'THE Cave'!")
        println()

        // option 1
        print("[1] SMALL Cave (12 squares & 5 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin $silverCoin ")
        println()
        // option 2
        print("[2] THE Cave   (20 squares & 6 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin")
        println()
        // option 3
        print("[3] BIG Cave   (25 squares & 8 coins):")
        println(" $goldCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin $silverCoin")
        println()
        // custom
        print("[4] Custom     (Make your own cave!):")
        println("  $goldCoin? $silverCoin?")
        println()

        print("Option: ")
        val caveOption = readln() // kept as string to be able to check or invalids

        when (caveOption) {
            "1" -> {
                gridSize = 12
                coinsNumber = 5
                break
            }

            "2" -> {
                gridSize = 20
                coinsNumber = 6
                break
            }

            "3" -> {
                gridSize = 25
                coinsNumber = 8
                break
            }

            "4" -> {
                println()
                println()
                println("✦ CUSTOM SETTINGS ✦".bold()) // heading

                while (true) {
                    // Get input for grid size
                    println()
                    print("1) Enter your desired cave grid size: ")
                    val customGridSize = readln().toIntOrNull()

                    // Check if newGridSize is valid
                    if (customGridSize == null || customGridSize <= 0) {
                        println()
                        println("Invalid input! Grid size can only be a positive number.".red())
                        continue // Ask for the input again
                    }
                    else if (customGridSize >= 60) {
                        println()
                        println("Invalid input! Cave is too big! (max size = 60)".red())
                        continue // Ask for the input again
                    }
                    else if (customGridSize < 5 && customGridSize > 0) {
                        println()
                        println("Invalid input! Cave is too small! (min size = 5).".red())
                        continue // Ask for the input again
                    }

                    // Get input for total number of coins
                    println()
                    print("2) Enter your desired total number of coins: ")
                    val customCoinsNumber = readln().toIntOrNull()

                    // Check if newCoinsNumber is valid
                    if (customCoinsNumber == null || customCoinsNumber < 0 || customCoinsNumber > customGridSize - 2) {
                        println()
                        println("Invalid input! Number of coins can only be a positive number that is at least 2 less than the grid size number.".red())
                        continue // Ask for the input again
                    }

                    println()

                    // Confirmation
                    print("Confirm these custom settings? [Y]es / [N]o: ")
                    val confirm = readln().uppercase().firstOrNull()?.toString()

                    when (confirm) {
                        "Y" -> {
                            // Update existing variables with new values
                            gridSize = customGridSize
                            coinsNumber = customCoinsNumber
                            break // Exit the loop after confirmation
                        }
                        "N" -> {
                            setupGame(grid)
                            break
                            // not confirm, so go back to options
                        }
                        else -> {
                            println("Invalid! Please choose either [Y]es or [N]o.".red())
                        }
                    }
                }
                break // continue with building the grid
            }

            else -> {
                println()
                println("That cave does not exist!".italic().red())
                println()
            }
        }
    }

    // Create a set to track occupied positions
    val occupiedPositions = mutableSetOf<Int>()

    // Place silver coins
    repeat(coinsNumber - 1) { // Place silver coins
        var position: Int
        do {
            position = (1 until gridSize).random() // Random position for silver coins
        } while (!occupiedPositions.add(position)) // Continue until a free space is found
        grid[position] = silverCoin
    }

    // Place gold coin
    var position: Int
    do {
        position = (1 until gridSize).random() // Random position for gold coin
    } while (!occupiedPositions.add(position)) // make sure it's a free space
    grid[position] = goldCoin

    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
}

fun showCave(grid: MutableList<String>) {
    //index box labelling
    for (i in grid.indices) {
        print("┊")
        val formattedNumber = i.toString().padStart(3, ' ').padEnd(5, ' ')
        print(formattedNumber)
//        print(String.format("%4d", i))
    }
    println("┊")


    // Build Top (of game grid)
    print("┌")
    print("─────┬".repeat(grid.size-1))
    print("─────")
    println("┐")

    //second line of table where coin are display
    for (square in grid) {

        print("|  $square  ")
    }
    println("|")

    //bottom line of table
     print("└")
    print("─────┴".repeat(grid.size-1))
    print("─────")
    println("┘")

}

fun moveCoin (grid: MutableList<String> ,players: MutableList<String>, currentTurn: Int){
    // Select coin
    println()
    print("Select the square number of the coin that you want to move: ")
    // Check for invalid inputs
    val selectedCoin = readln().toIntOrNull() ?: run {
        println("Invalid input! Please enter a valid integer.".red())
        return // Exit the function on invalid input
    }

    // Check for valid indices & whether a coin is already there for 'selectedCoin'
    if (selectedCoin !in grid.indices || grid[selectedCoin] != goldCoin
        && grid[selectedCoin] != silverCoin) {
        println()
        println("Invalid selection! Please select a grid with an existing coin!" .red())
    }

    println()

    //check for remove coin
    if(selectedCoin == 0){
        print("Would you like to remove this coin? [Y]es / [N]o: ")
        val removeOption: String = readln().uppercase().firstOrNull()?.toString() ?: ""

        while (true) {
            when (removeOption) {
                "Y" -> {
                    if (grid[0] == goldCoin) {
                        endingScene(grid, players, currentTurn)
                        return
                    }
                    else {
                        grid[0] = " "
                        return
                    }
                }

                "N" -> {
                    moveCoin(grid, players, currentTurn)
                    return
                }

                else -> {
                    println("Invalid! Please enter [Y]es or [N]o.".red())
                    return
                }
            }
        }

    }

    // determining coin moving destination
    print("Select the slot where you want to move the coin to: ")
    // Check for invalid inputs
    val moveTo = readln().toIntOrNull() ?: run {
        println()
        println("Invalid input! Please enter a valid integer.".red())
        return
    }

    // Check for valid indices of 'moveTo'
    if ( moveTo !in grid.indices) {
        println()
        println("Invalid index! Cannot move the coin there!" .red())
    }

    // Check for valid move of right to left ←←←
    if (moveTo > selectedCoin){
        println()
        println("Invalid move! Coin can only be moved from right to left (←←←).".red())
    }

    // Check if destination is empty (no coin)
    if (grid[moveTo] == silverCoin || grid[moveTo] == goldCoin) {
        println()
        println("Invalid move! You cannot move a coin to a position with an existing coin.".red())
    }

    // Check for jumping over coins
    for (i in (moveTo + 1) until selectedCoin) {
        if (grid[i] == goldCoin || grid[i] == silverCoin) {
            println()
            println("Invalid move! You cannot jump over a coin.".red())
            return
        }
    }

    //If everything is valid, then coin is successfully moved!
    val temp = grid[selectedCoin]
    grid[selectedCoin] = grid[moveTo]
    grid[moveTo] = temp

}

fun playGame(grid: MutableList<String>, players: MutableList<String>, turn: Int) {
    println()
    showCave(grid)
    println()

    var currentTurn = turn

    while (true) {
        println()
        if (currentTurn == 0) {
            println("It's ${players[0]}'s turn!")
            moveCoin(grid, players, currentTurn)
            //next player
            currentTurn = 1
        }
        else if (currentTurn == 1){
            println()
            println("It's ${players[1]}'s turn!")
            moveCoin(grid, players, currentTurn)
            //change player's turn
            currentTurn = 0
        }

        //show updated cave
        println()
        showCave(grid)
    }

}

fun endingScene(grid: MutableList<String>, players: MutableList<String>, currentTurn: Int) {
    println()
    if (currentTurn == 0){
        println("${players[0]} WON!")
    }
    else {
        println("${players[1]} WON!")
    }

    println()
    print("Press ENTER to return to main menu...")
    readln()

    println("\n".repeat(50))
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println("\n".repeat(5))
    main()
}




/** OLD VERSION OF COINS RANDOM GENERATOR THAT DOESN'T HAVE ECC -----------------

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

 */
