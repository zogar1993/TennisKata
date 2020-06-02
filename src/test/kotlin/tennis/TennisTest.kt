package tennis

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test

class TennisTest {
    @Test
    fun `a new game starts as 'love-love'`(){
        val game = Game.new()

        game.score.shouldBeEqualTo("love-love")
    }

    class Game private constructor() {
        var score = "love-love"
        companion object {
            fun new() = Game()
        }
    }
}