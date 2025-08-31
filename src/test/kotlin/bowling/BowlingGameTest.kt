package bowling

import org.assertj.core.api.Assertions.assertThat
import org.example.bowling.Game
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

// gutter gane: 0
// all ones:
class BowlingGameTest {
    lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    private fun rollMany(
        n: Int,
        pins: Int,
    ) {
        repeat(n) {
            game.roll(pins)
        }
    }

    @Test
    fun `gutter game`() {
        rollMany(20, 0)

        assertThat(game.score()).isEqualTo(0)
    }

    @Test
    fun `all ones`() {
        rollMany(20, 1)

        assertThat(game.score()).isEqualTo(20)
    }
}
