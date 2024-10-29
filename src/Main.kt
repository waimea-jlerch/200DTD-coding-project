/**
 * ------------------------------------------------------------------------
 * Ancient Gold Coin: Your Shot to Wealthiness
 * Level 2 programming project
 *
 * by Jess Lerch
 *
 * The project involves the programming of a two-player game.
 * It is a game about competing to obtain the 'Ancient gold coin' before your opponent
 * to gain your shortcut to long-lasting wealthiness!
 * This game is a two player game played on a one-dimensional grid of squares.
 * A certain number coins are randomly placed onto the grid.
 * Most of the coins are normal coin that are worthless except
 * for one of the coins that is the one and only 'Ancient Gold Coin'.
 * Players will take turns move the coins from right to left.
 * When a coin is at the most left grid, it can be removed of the grid.
 * First player to remove the 'Ancient Gold Coin' wins!
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */
val silverCoin = "●".grey()
val goldCoin = "●".col("#ebce38")
const val space = " "

fun main() {
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()
    // Welcome message
    println( "╭──────────────────────────────────────────────╮\n" +
             "│ " + goldCoin + " Welcome to 'Ancient Gold Coin' the Game! ".bold() + silverCoin + " │\n" +
             "╰──────────────────────────────────────────────╯" )

    val players = mutableListOf<String>()
    val grid = mutableListOf<String>()
    val currentTurn = 0

    while (true) {
    // Get action choice from user
    val option = getUserAction()
        when (option) {
            'P'  -> {
                 getNames(players)
                 startIntro(players)          // start with introduction
                 setupGame(grid)
                 playGame(grid, players, currentTurn)
            }
            'S'  -> {
                 getNames(players)
                 setupGame(grid)              // start without introduction
                 playGame(grid, players, currentTurn)
            }
            'R'  -> rules()                   // view rules
            'Q'  -> System.exit(0)     // Exit
            else -> println("Invalid option! Please select an option from the main menu!".red())
        }
    }

}

// Get user action from menu by:
// Displaying a list of options
// Get the user's choice.
// Returns just the first character in UPPERCASE
fun getUserAction(): Char {
    while(true) {
        println()

        // Show options
        println("✦ MENU ✦".bold())
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
        else if (option.isEmpty()){
            println("Invalid option! Please select an option from the main menu!".red())
        }
    }
}

// Game starting Introduction (main character is randomized)
fun startIntro(players: MutableList<String>) {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    val mainP = players.indices.random()
    val sideP = if (mainP == 0) 1 else 0

    println("Imagine a scenario where ${players[mainP]} just lost their job and they are really in need of a lot of money, an amount that would\n" +
            "turn ${players[mainP]}'s life around forever without the need to worry about finance again. ${players[mainP]} recently found a very old looking map\n" +
            "in their grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.\n" +
            "As this is ${players[mainP]}'s chance to change your life around, they think it is worth the risk to follow that map and find\n" +
            "what it is hiding... After a long struggle, in a cave, ${players[mainP]} manage to find what seemed to be the treasure that the map is\n" +
            "leading you to, the 'Ancient Gold Coin'. However, there's always a catch. A silhouette slowly appear which seem to be ${players[sideP]}!\n" +
            "Watch out, both of you now have to compete and prove yourself to the cave that you are worthy to receive the coin!\n" +
            "This is your last shot to wealthiness, and you must win this!")

    println()
    print("Press " + "Enter".bold().col("#e3e3e3") + " to continue...")
    readln()
}

// Get players name from user's input
fun getNames(players: MutableList<String>) {

    println()
    // adding player 1's name
    println("Enter players name")
    print("✦".col("#4fb3ff") + " Player 1 : ")
    val player1 : String = readln().trim()
    // check for empty input
    if (player1.isNotBlank() ) {
        players.add(player1)
    }
    else{
        players.add("Mr.Kneecap") // if null use default name
    }

    // put in loop for invalid checking
    while (true) {
        //getting player 2's name
        print("✦".col("#cf7336") +" Player 2 : ")
        val player2 : String = readln().trim()

        // check for empty input and duplicates
        if (player2.isNotBlank()) {
            if (player2 != player1) {
                players.add(player2)
                break // Exit the loop if the name is valid
            } else {
                println("This name already exists! Please enter a different player name.".red())
                println()

            }
        } else {
            players.add("Mr.Longlegs") // if null use default name
            break
        }
    }

    // display name
    println()
    if (players[0] == "Mr.Kneecap" || players[1] == "Mr.Longlegs")
        println("Default names are used for players with blank names.".grey())
    println("Hi Player 1, your name is " + players[0].bold().col("#4fb3ff"))
    println("             AND")
    println("Hi Player 2, your name is " + players[1].bold().col("#cf7336"))
}

// View Rules!
fun rules() {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    println("The way of proving yourself to the cave and " + "how to win".underline().italic() + " (rules):\n" +
            "This game is a two player game played on a one-dimensional grid of squares. A certain number coins are randomly\n" +
            "placed onto the grid. Most of the coins are normal coin that are worthless except for one of the coins that is the\n" +
            "one and only 'Ancient Gold Coin'. Players will take turns to play. Each turn consists of only 1 move.\n" +
            "The available moves that a player can do are:\n" +
            "1) Slide any coin any number of spaces to the *left* on a condition that:\n" +
            "      - A coin cannot jump over another coin\n" +
            "      - It does not share the same square with another coin\n" +
            "2) Remove a coin when it is placed/moved to the most-left grid / in position 1\n" +
            "\n" +
            "To win, you have to be the first to successfully " + "removed".underline().italic() + " the 'Ancient Gold Coin' from the grid!")

    println()
    print("Press " + "Enter".bold().col("#e3e3e3") + " to return...")
    readln()
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
}

// grid and coin selector
fun setupGame(grid: MutableList<String>) {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")

    var gridSize = 0
    var coinsNumber = 0

    while(true) {
        println()
        println("✦ SELECT YOUR CAVE! ✦".bold())
        println("┌───────────────────────────────────────┐\n".grey() +
                "│ Note: Recommended Cave is 'THE Cave'! │\n".grey() +
                "└───────────────────────────────────────┘"  .grey())
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
                println("┌─────────────────────────────────────────────────────────────────────────────────────┐\n" +
                        "│   Note:                                                                             │\n" +
                        "│  - Max cave size is 60                                                              │\n" +
                        "│  - Min cave size is 5                                                               │\n" +
                        "│  - Coins number cannot exceed and must be at least 2 less than cave size            │\n" +
                        "│  - If any invalid input is detected you are required to enter everything in again.  │\n" +
                        "└─────────────────────────────────────────────────────────────────────────────────────┘")

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

    // Build the grid
    for (i in 0 until gridSize) {
        grid.add(space)
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

// Game grid formatting
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

// Moving coin and invalid move checking
fun moveCoin (grid: MutableList<String> ,players: MutableList<String>, currentTurn: Int): Int{
    // Select coin
    println()
    print("Select the square number of the coin that you want to move: ")
    // Check for invalid inputs
    val selectedCoin = readln().toIntOrNull() ?: run {
        println("Invalid input! Please enter a valid integer.".red())
        return currentTurn // Exit function as invalid input is detected
    }

    // Check for valid indices & whether a coin is already there for 'selectedCoin'
    if (selectedCoin !in grid.indices || grid[selectedCoin] != goldCoin
        && grid[selectedCoin] != silverCoin) {
        println("Invalid selection! Please select a grid with an existing coin!" .red())
        return currentTurn
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
                        endingScene(players, currentTurn)
                        // return same player turn as they have won
                        return currentTurn
                    }
                    else {
                        grid[0] = " "
                        // update turn
                        return if (currentTurn == 0) 1 else 0
                    }
                }

                "N" -> {
                    moveCoin(grid, players, currentTurn)
                    return currentTurn
                }

                else -> {
                    println("Invalid! Please enter [Y]es or [N]o.".red())
                    return currentTurn
                }
            }
        }

    }

    // determining coin moving destination
    print("Select the slot where you want to move the coin to: ")
    // Check for invalid inputs
    val moveTo = readln().toIntOrNull() ?: run {
        println("Invalid input! Please enter a valid integer.".red())
        return currentTurn
    }

    // Check for valid indices of 'moveTo'
    if ( moveTo !in grid.indices) {
        println("Invalid index! Cannot move the coin there!" .red())
        return currentTurn
    }

    // Check for valid move of right to left ←←←
    if (moveTo > selectedCoin){
        println("Invalid move! Coin can only be moved from right to left (←←←).".red())
        return currentTurn
    }

    // Check if destination is empty (no coin)
    if (grid[moveTo] == silverCoin || grid[moveTo] == goldCoin) {
        println("Invalid move! You cannot move a coin to a position with an existing coin.".red())
        return currentTurn
    }

    // Check for jumping over coins
    for (i in (moveTo + 1) until selectedCoin) {
        if (grid[i] == goldCoin || grid[i] == silverCoin) {
            println("Invalid move! You cannot jump over a coin.".red())
            return currentTurn
        }
    }

    //If everything is valid, then coin is successfully moved!
    val temp = grid[selectedCoin]
    grid[selectedCoin] = grid[moveTo]
    grid[moveTo] = temp
    // Update turn
    return if (currentTurn == 0) 1 else 0

}

// Get user move and swapped player
fun playGame(grid: MutableList<String>, players: MutableList<String>, currentTurn: Int) {
    println()
    showCave(grid)

    var currentPlayerTurn = currentTurn

    while (true) {
        println()
        if (currentPlayerTurn == 0) {
            println("It's " + "${players[currentPlayerTurn]}'s".col("#4fb3ff").bold() + " turn!")
        }
        else if (currentPlayerTurn ==1){
            println("It's " + "${players[currentPlayerTurn]}'s".col("#cf7336").bold() + " turn!")
        }
//        // Use currentPlayerTurn for display
//        println("It's" + "${players[currentPlayerTurn]}'s" + "turn!")

        // get updated turn
        currentPlayerTurn = moveCoin(grid, players, currentPlayerTurn)

        //show updated cave
        println()
        showCave(grid)
    }

}

// Ending story and show winner
fun endingScene(players: MutableList<String>, currentTurn: Int) {
    println("\n".repeat(5))
    println("⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀\n".col("#FFD700") +
            "⢠⣤⣤⣤⣼⡇⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣄⣤⣤⣠\n".col("#FFD700") +
            "⢸⠀⡶⠶⠾⡇⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡷⠶⠶⡆⡼\n".col("#FFD700") +
            "⠈⡇⢷⠀⠀⣇  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠇⠀⢸⢁⡗\n".col("#FFD700") +
            "⠀ ⢹⡘⡆⠀⢹⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠀⢀⡏⡼⠀\n".col("#FFD700") +
            "⠀ ⠀⢳⡙⣆⠈⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠇⢀⠞⡼⠁⠀\n".col("#FFD700") +
            "⠀⠀ ⠀⠙⣌⠳⣼⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣞⡴⣫⠞⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀ ⠀⠈⠓⢮⣻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡼⣩⠞⠉⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀ ⠀⠉⠛⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠋⠁⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠈⠳⢤⣀⠀⠀⠀⠀⢀⣠⠖⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠈⠉⡇⢸⡏⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⡇⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⢠⠖⠒⠓⠚⠓⠒⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀  ⣀⣠⣞⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⣉⣙⣆⣀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⡇⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀     ⠀⡇⠀⠀⠀⠀⠀⠀\n".col("#FFD700") +
            "⠀⠀⠀⠀⠀⠀⠀⠓⠲⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠖⠃⠀⠀⠀⠀⠀⠀".col("#FFD700"))
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    val loser = if (currentTurn == 0) 1 else 0

    print("Congratulations ${players[currentTurn]}!".bold().italic())
    print(" ${players[currentTurn]} took the Ancient Gold Coin back home with grace before selling it to " + "Melon Ausk\n".underline() +
            "the wealthiest man on Earth. Melon Ausk just discover his new found love of collecting rare antiques and this 'Ancient Gold Coin'\n" +
            "is so precious and mysterious that Melon Ausk is willing to pay an absurd amount of money to grant the coin as his own. \n" +
            "This amount of money is enough for ${players[currentTurn]} to live happily without the need to work again, as well as enough\n" +
            "to pass this comfortable lifestyle to the next few generations of theirs.\n" +
            "${players[currentTurn]} have won the shortcut to wealthiness!\n".bold().italic() +
            "\n" +
            "${players[currentTurn]} walks home while humming a happy song, but only if they know that ${players[loser]} is furious by their defeat.\n" +
            "${players[loser]} lurks in the dark watching every step of ${players[currentTurn]}. Fist clenched, ${players[loser]} wonder and hope\n" +
            "for the day that they will get their REVENGE!\n" +
            "\n" +
            "THE END\n".italic())

    println()
    print("Press " + "Enter".bold().col("#e3e3e3") + " to return to main menu...")
    readln()

    println("\n".repeat(50))
    main()
}



/**
 * Program end point
 */