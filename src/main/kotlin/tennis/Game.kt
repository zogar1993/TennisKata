package tennis

import kotlin.math.abs

class Game private constructor() {
    private var player1Score = 0
    private var player2Score = 0

    fun player1Scores() {
        if (gameAlreadyFinished) throw GameAlreadyFinished()
        player1Score++
    }

    fun player2Scores() {
        if (gameAlreadyFinished) throw GameAlreadyFinished()
        player2Score++
    }

    val score: String get() {
        if (atLeast3PointsWhereScoredByEachPlayer){
            return when {
                playerScoresAreEqual -> "deuce"
                player1ScoreIsOneMoreThanHisOpponents -> "advantage for player 1"
                player2ScoreIsOneMoreThanHisOpponents -> "advantage for player 2"
                player1ScoreIsTwoMoreThanHisOpponents -> "player 1 won the game"
                player2ScoreIsTwoMoreThanHisOpponents -> "player 2 won the game"
                else -> throw NotImplementedError()
            }
        }

        if (player1Score == 4) return "player 1 won the game"
        if (player2Score == 4) return "player 2 won the game"

        return "${scoreToText(player1Score)}-${scoreToText(player2Score)}"
    }

    private val player1ScoreIsOneMoreThanHisOpponents get() =
        player1Score == player2Score + 1

    private val player2ScoreIsOneMoreThanHisOpponents get() =
        player2Score == player1Score + 1

    private val player1ScoreIsTwoMoreThanHisOpponents get() =
        player1Score == player2Score + 2

    private val player2ScoreIsTwoMoreThanHisOpponents get() =
        player2Score == player1Score + 2

    private val playerScoresAreEqual get() =
        player1Score == player2Score

    private val atLeast3PointsWhereScoredByEachPlayer get() =
        player1Score >= 3 && player2Score >= 3

    private val gameAlreadyFinished get() =
        if (atLeast3PointsWhereScoredByEachPlayer)
            abs(player1Score - player2Score) == 2
        else player1Score == 4 || player2Score == 4


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