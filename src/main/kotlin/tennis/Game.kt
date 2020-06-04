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
        if (atLeast3PointsWhereScoredByEachPlayer()){
            if (playerScoresAreEqual()) return "deuce"
            if (player1ScoreIsOneMoreThanHisOpponents()) return "advantage for player 1"
            if (player2ScoreIsOneMoreThanHisOpponents()) return "advantage for player 2"
        }

        return "${scoreToText(player1Score)}-${scoreToText(player2Score)}"
    }

    private fun player1ScoreIsOneMoreThanHisOpponents() = player1Score == player2Score + 1
    private fun player2ScoreIsOneMoreThanHisOpponents() = player2Score == player1Score + 1
    private fun playerScoresAreEqual() = player1Score == player2Score
    private fun atLeast3PointsWhereScoredByEachPlayer() = player1Score >= 3 && player2Score >= 3

    private fun scoreToText(score: Int): String {
        return when (score) {
            0 -> "love"
            1 -> "fifteen"
            2 -> "thirty"
            3 -> "forty"
            else -> throw NotImplementedError()
        }
    }

    companion object {
        fun new() = Game()
    }
}