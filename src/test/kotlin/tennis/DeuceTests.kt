package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class DeuceTests {
    @Test
    fun `the game being 'forty-thirty', player 2 scores, game is 'deuce'`(){
        val game = `forty-thirty game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("deuce")
    }

    @Test
    fun `the game being 'thirty-forty', player 1 scores, game is 'deuce'`(){
        val game = `thirty-forty game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("deuce")
    }

    @Test
    fun `the game being 'advantage player 1', player 2 scores, game is 'deuce'`(){
        val game = `advantage for player 1`()

        game.player2Scores()

        game.score.shouldBeEqualTo("deuce")
    }

    @Test
    fun `the game being 'advantage for player 2', player 1 scores, game is 'deuce'`(){
        val game = `advantage for player 2`()

        game.player1Scores()

        game.score.shouldBeEqualTo("deuce")
    }
}

