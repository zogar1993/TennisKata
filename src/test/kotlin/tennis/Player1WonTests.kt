package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class Player1WonTests {
    @Test
    fun `Player 1 won, Player 2 scored 0 points`(){
        val game = `new game`()

        repeat(4) { game.player1Scores() }

        game.score.shouldBeEqualTo("player 1 won the game")
    }

    @Test
    fun `Player 1 won, Player 2 scored 1 points`(){
        val game = `new game`()

        repeat(1) { game.player2Scores() }
        repeat(4) { game.player1Scores() }

        game.score.shouldBeEqualTo("player 1 won the game")
    }

    @Test
    fun `Player 1 won, Player 2 scored 2 points`(){
        val game = `new game`()

        repeat(2) { game.player2Scores() }
        repeat(4) { game.player1Scores() }

        game.score.shouldBeEqualTo("player 1 won the game")
    }

    @Test
    fun `Player 1 won scoring after he had advantage`(){
        val game = `advantage for player 1 game`()

        game.player1Scores()

        game.score.shouldBeEqualTo("player 1 won the game")
    }
}