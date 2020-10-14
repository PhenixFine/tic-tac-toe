import kotlin.math.absoluteValue

fun main() {
    val string = getString("Enter cells: ")
    val cells = string.chunked(3)
    val dashes = "-".repeat(9)
    val xCount = string.count { it == 'X' }
    val oCount = string.count { it == 'O' }
    val xWins = checkWin(cells, 'X')
    val oWins = checkWin(cells, 'O')
    val empty = string.contains('_')

    println(dashes)
    cells.forEach { line -> print("| "); line.chunked(1).forEach { print("$it ") }; println("|") }
    println(dashes)
    when {
        ((xWins && oWins) || (xCount - oCount).absoluteValue > 1) -> println("Impossible")
        xWins -> println("X wins")
        oWins -> println("O wins")
        empty -> println("Game not finished")
        else -> println("Draw")
    }
}

fun checkWin(cells: List<String>, check: Char): Boolean {
    cells.forEach { line -> if (line.all { it == check }) return true }
    for (i in cells.indices) if (cells[0][i] == check && cells[1][i] == check && cells[2][i] == check) return true
    if (cells[0][0] == check && cells[1][1] == check && cells[2][2] == check) return true
    if (cells[0][2] == check && cells[1][1] == check && cells[2][0] == check) return true
    return false
}

fun getString(text: String): String {
    print(text)
    return readLine()!!
}