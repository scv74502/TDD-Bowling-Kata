package bowling

import org.assertj.core.api.Assertions
import org.example.bowling.Game
import org.junit.jupiter.api.Test

class BowlingGameTest {
    @Test
    fun `gutter game`() {
        val game = Game()

        repeat(20) {
            game.roll(0)
        }

        Assertions.assertThat(game.score()).isEqualTo(0)
    }
}
