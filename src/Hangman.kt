import kotlin.random.Random

private val words = listOf(
    "jackpot",
    "gossip",
    "flyby",
    "duplex",
    "jazzy",
    "jukebox",
    "kazoo",
    "keyhole",
    "kiosk",
    "luxury",
    "matrix",
    "microwave",
    "nightclub",
    "oxidize",
    "queue",
    "puzzling",
    "strength",
    "yummy",
    "zigzag",
    "vodka"
)
private var word = ""
private var guesses = arrayListOf<Char>()
private var remainingGuesses = 6
private var mistakes = 0

fun main(args: Array<String>) {
    setupGame()
}

fun setupGame() {
    val wordIndex = Random.nextInt(words.size)
    word = words[wordIndex].toUpperCase()
    println(word)
    for (i in word.indices) {
        guesses.add('_')
    }
    var gameOver = false
    do {
        printGameStatus()
        println("Please enter a letter:")
        val input = readLine() ?: ""
        if (input.isEmpty()) {
            println("That's not a valid input. Please try again")
        } else {
            val letter = input[0].toUpperCase()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if (word[i] == letter) {
                        guesses[i] = letter
                    }
                }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("Sorry, that's not part of word")
                remainingGuesses--
                mistakes++
                if (mistakes == 6)
                    gameOver = true
            }
        }
    } while (!gameOver)

    if (mistakes == 6){
        printGameStatus()
        println("Sorry, you lost. The word was \n$word")
    }else{
        println("\nCongratulation, you win!")
        println("The word was $word")
    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        6 -> print6Mistakes()
    }

    print("Word: ")
    for (element in guesses) {
        print("$element ")
    }
    println("\n You have $remainingGuesses guesses left")
}

fun print0Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\     ")
    println("/ | \\     ")
}

fun print1Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\     ")
    println("/ | \\     ")
}

fun print2Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print3Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     /   ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6Mistakes() {
    println("  |------|-")
    println("  |------| ")
    println("  |      0 ")
    println("  |     /|\\")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}