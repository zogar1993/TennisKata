package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class AdvantageTests {
    @Test
    fun `the game being 'deuce', player 1 scores, game is 'advantage for player 1'`(){
        val game = `deuce game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("advantage for player 1")
    }

    @Test
    fun `the game being 'deuce', player 2 scores, game is 'advantage for player 2'`(){
        val game = `deuce game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("advantage for player 2")
    }
}