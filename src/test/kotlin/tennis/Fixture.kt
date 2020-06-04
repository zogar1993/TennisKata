package tennis

import org.amshove.kluent.shouldBeEqualTo


fun `new game`(): Game {
    return Game.new()
}

fun `fifteen-fifteen game`(): Game {
    val game = Game.new()

    game.player1Scores()
    game.player2Scores()

    game.score.shouldBeEqualTo("fifteen-fifteen")
    return game
}

fun `thirty-thirty game`(): Game {
    val game = `fifteen-fifteen game`()

    game.player1Scores()
    game.player2Scores()

    game.score.shouldBeEqualTo("thirty-thirty")
    return game
}

fun `forty-thirty game`(): Game {
    val game = `thirty-thirty game`()

    game.player1Scores()

    game.score.shouldBeEqualTo("forty-thirty")
    return game
}

fun `thirty-forty game`(): Game {
    val game = `thirty-thirty game`()

    game.player2Scores()
    game.score.shouldBeEqualTo("thirty-forty")

    return game
}

fun `deuce game`(): Game {
    val game = `thirty-thirty game`()

    game.player1Scores()
    game.player2Scores()

    game.score.shouldBeEqualTo("deuce")
    return game
}

fun `advantage for player 1 game`(): Game {
    val game = `deuce game`()

    game.player1Scores()

    game.score.shouldBeEqualTo("advantage for player 1")
    return game
}

fun `advantage for player 2 game`(): Game {
    val game = `deuce game`()

    game.player2Scores()

    game.score.shouldBeEqualTo("advantage for player 2")
    return game
}