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
val players = mutableListOf<String>()

fun main() {
    // Welcome message
    println("Welcome to 'Ancient Gold Coin' the Game!")

    showNames(players)

    // Get action choice from user
    val option = getUserAction()
    when (option) {
        'P' -> startIntro()       // start with introduction
        'S' -> showNames(players)        // Start without introduction
        'R' -> rules()            // view rules
        //'Q' -> break

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
        println(" [S] Skip Introduction")
        println(" [R] View Rules")
        print("Option: ")

        // Get user choice
        val option = readln()

        if (option.isNotEmpty()) {
            // Return just the first char
            return option.uppercase().first()
        }
    }
}

fun startIntro() {
    println()
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    println("Imagine a scenario where $player1 just lost their job and they are really in need of a lot of money, an amount that would\n" +
            "turn $player1's life around forever without the need to worry about finance again. $player1 recently found a very old looking map\n" +
            "in their grandparent's basement in a small wooden chest that seemed to be left unbothered for centuries.\n" +
            "As this is $player1's chance to change your life around, they think it is worth the risk to follow that map and find\n" +
            "what it is hiding... After a long struggle, in a cave, $player1 manage to find what seemed to be the treasure that the map is\n" +
            "leading you to, the 'Ancient Gold Coin'. However, there's always a catch. A silhouette slowly appear which seem to be $player2!\n" +
            "Watch out, both of you now have to compete and prove yourself\n" +
            "to the cave that you are worthy to receive the coin! This is your last shot to wealthiness, and you must win this!")

    println()
    readln()
    caveSelector()
    return
}

/** skip intro */
fun showNames(players: MutableList<String>) {
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()

    println("Enter players name")
    println("Player 1 : ")
    val player1 : String = readln()
    println("Player 2 : ")
    val player2 : String = readln()
    println()

    return
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
    println("---------------------------------------------------------------------------------------------------------------------------------------")
    println()


    val option = getUserAction()
    when (option) {
        'P' -> startIntro()       // start with introduction
        'S' -> showNames(players)        // Start without introduction
        'R' -> rules()            // view rules
    }

}

/** grid and coin selector  */
fun caveSelector() {
    println("Select your cave!")
}