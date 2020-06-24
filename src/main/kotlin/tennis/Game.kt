package tennis

class Game private constructor() {
    private var _score: Score = SimpleScore()

    fun player1Scores() {
        _score = _score.player1Scores()
    }

    fun player2Scores() {
        _score = _score.player2Scores()
    }

    val score: String get() = _score.score()

    companion object {
        fun new() = Game()
    }
}

interface Score {
    fun player1Scores(): Score
    fun player2Scores(): Score
    fun score(): String
}

class SimpleScore(
        private val player1Score: Int = 0,
        private val player2Score: Int = 0) : Score {
    override fun player1Scores(): Score {
        val player1Score = player1Score + 1
        if (player1Score == 4 && player2Score < 3) return Player1WonScore
        if (player1Score == 3 && player2Score == 3) return DeuceScore
        if (player1Score == 4 && player2Score == 3) return AdvantagePlayer1Score

        return SimpleScore(player1Score, player2Score)
    }

    override fun player2Scores(): Score {
        val player2Score = player2Score + 1
        if (player2Score == 4 && player1Score < 3) return Player2WonScore
        if (player2Score == 3 && player1Score == 3) return DeuceScore
        if (player2Score == 4 && player1Score == 3) return AdvantagePlayer2Score

        return SimpleScore(player1Score, player2Score)
    }

    override fun score(): String {
        return "${scoreToText(player1Score)}-${scoreToText(player2Score)}"
    }

    private fun scoreToText(score: Int): String {
        return when (score) {
            0 -> "love"
            1 -> "fifteen"
            2 -> "thirty"
            3 -> "forty"
            else -> throw NotImplementedError()
        }
    }
}

object Player1WonScore : Score {
    override fun player1Scores(): Score = throw GameAlreadyFinished()
    override fun player2Scores(): Score = throw GameAlreadyFinished()
    override fun score(): String = "player 1 won the game"
}

object Player2WonScore : Score {
    override fun player1Scores(): Score = throw GameAlreadyFinished()
    override fun player2Scores(): Score = throw GameAlreadyFinished()
    override fun score(): String = "player 2 won the game"
}

object DeuceScore : Score {
    override fun player1Scores(): Score = AdvantagePlayer1Score
    override fun player2Scores(): Score = AdvantagePlayer2Score
    override fun score(): String = "deuce"
}

object AdvantagePlayer1Score : Score {
    override fun player1Scores(): Score = Player1WonScore
    override fun player2Scores(): Score = DeuceScore
    override fun score(): String = "advantage for player 1"
}

object AdvantagePlayer2Score : Score {
    override fun player1Scores(): Score = DeuceScore
    override fun player2Scores(): Score = Player2WonScore
    override fun score(): String = "advantage for player 2"
}