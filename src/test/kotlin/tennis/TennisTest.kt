package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class TennisTest {
    @Test
    fun `a new game starts as 'love-love'`(){
        val game = Game.new()

        game.score.shouldBeEqualTo("love-love")
    }

    @Test
    fun `the game being 'love-love', player 1 scores, game is 'fifteen-love'`(){
        val game = Game.new()

        game.scoreForPlayer(1)

        game.score.shouldBeEqualTo("fifteen-love")
    }

    @Test
    fun `the game being 'love-love', player 2 scores, game is 'love-fifteen'`(){
        val game = Game.new()

        game.scoreForPlayer(2)

        game.score.shouldBeEqualTo("love-fifteen")
    }

    class Game private constructor() {
        private var player1Score = 0
        fun scoreForPlayer(player: Int) {
            player1Score++
        }

        val score: String get() {
            return "${scoreToText(player1Score)}-love"
        }

        private fun scoreToText(score: Int): String {
            return when (score) {
                0 -> "love"
                1 -> "fifteen"
                else -> throw NotImplementedError()
            }
        }

        companion object {
            fun new() = Game()
        }
    }
}