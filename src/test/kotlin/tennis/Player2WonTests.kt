package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class Player2WonTests {
    @Test
    fun `Player 2 won, Player 1 scored 0 points`(){
        val game = `new game`()

        repeat(4) { game.player2Scores() }

        game.score.shouldBeEqualTo("player 2 won the game")
    }

    @Test
    fun `Player 2 won, Player 1 scored 1 points`(){
        val game = `new game`()

        repeat(1) { game.player1Scores() }
        repeat(4) { game.player2Scores() }

        game.score.shouldBeEqualTo("player 2 won the game")
    }

    @Test
    fun `Player 2 won, Player 1 scored 2 points`(){
        val game = `new game`()

        repeat(2) { game.player1Scores() }
        repeat(4) { game.player2Scores() }

        game.score.shouldBeEqualTo("player 2 won the game")
    }

    @Test
    fun `Player 2 won scoring after he had advantage`(){
        val game = `advantage for player 2 game`()

        game.player2Scores()

        game.score.shouldBeEqualTo("player 2 won the game")
    }
}