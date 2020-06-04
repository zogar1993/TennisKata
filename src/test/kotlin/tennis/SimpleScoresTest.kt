package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class SimpleScoresTest {
    @Test
    fun `a new game starts as 'love-love'`(){
        val game = `new game`()

        game.score.shouldBeEqualTo("love-love")
    }

    @Test
    fun `the game being 'love-love', player 1 scores, game is 'fifteen-love'`(){
        val game = `new game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("fifteen-love")
    }

    @Test
    fun `the game being 'love-love', player 2 scores, game is 'love-fifteen'`(){
        val game = `new game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("love-fifteen")
    }

    @Test
    fun `when both players score, game is 'fifteen-fifteen'`(){
        val game = `new game`()

        game.player1Scores()
        game.player2Scores()

        game.score.shouldBeEqualTo("fifteen-fifteen")
    }

    @Test
    fun `the game being 'fifteen-fifteen', player 1 scores, game is 'thirty-fifteen'`(){
        val game = `fifteen-fifteen game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("thirty-fifteen")
    }

    @Test
    fun `the game being 'fifteen-fifteen', player 2 scores, game is 'fifteen-thirty'`(){
        val game = `fifteen-fifteen game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("fifteen-thirty")
    }

    @Test
    fun `the game being 'fifteen-fifteen', both players score, game is 'thirty-thirty'`(){
        val game = `fifteen-fifteen game`()

        game.player1Scores()
        game.player2Scores()

        game.score.shouldBeEqualTo("thirty-thirty")
    }

    @Test
    fun `the game being 'thirty-thirty', player 1 scores, game is 'forty-thirty'`(){
        val game = `thirty-thirty game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("forty-thirty")
    }

    @Test
    fun `the game being 'thirty-thirty', player 2 scores, game is 'thirty-forty'`(){
        val game = `thirty-thirty game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("thirty-forty")
    }
}

