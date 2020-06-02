package tennis

class Game private constructor() {
    private var player1Score = 0
    private var player2Score = 0

    fun player1Scores() {
        player1Score++
    }

    fun player2Scores() {
        player2Score++
    }

    val score: String get() {
        return "${scoreToText(player1Score)}-${scoreToText(player2Score)}"
    }

    private fun scoreToText(score: Int): String {
        return when (score) {
            0 -> "love"
            1 -> "fifteen"
            2 -> "thirty"
            else -> throw NotImplementedError()
        }
    }

    companion object {
        fun new() = Game()
    }
}