package tennis

import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test

class Player2ScoringAfterWinningTests {
    @Test
    fun `Player 2 scores after winning his advantage, should fail because he already won`(){
        val game = `advantage for player 2 game`()

        game.player2Scores()

        runCatching { game.player2Scores() }.
        onSuccess { shouldHaveFailed() }.
        onFailure { it.shouldBeInstanceOf<GameAlreadyFinished>() }
    }

    @Test
    fun `Player 2 scores after winning normally, should fail because he already won`(){
        val game = `new game`()

        repeat(4) { game.player2Scores() }

        runCatching { game.player2Scores() }.
        onSuccess { shouldHaveFailed() }.
        onFailure { it.shouldBeInstanceOf<GameAlreadyFinished>() }
    }

    @Test
    fun `Player 2 scores after Player 1 won his advantage, should fail because he already won`(){
        val game = `advantage for player 1 game`()

        game.player1Scores()

        runCatching { game.player2Scores() }.
        onSuccess { shouldHaveFailed() }.
        onFailure { it.shouldBeInstanceOf<GameAlreadyFinished>() }
    }

    @Test
    fun `Player 1 scores after Player 1 won normally, should fail because he already won`(){
        val game = `new game`()

        repeat(4) { game.player1Scores() }

        runCatching { game.player2Scores() }.
        onSuccess { shouldHaveFailed() }.
        onFailure { it.shouldBeInstanceOf<GameAlreadyFinished>() }
    }
}

