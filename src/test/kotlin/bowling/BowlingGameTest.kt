package bowling

import org.assertj.core.api.Assertions.assertThat
import org.example.bowling.Game
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.Ignore

// one strike
// perfect game
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

    @Test
    fun `one spare`() {
        rollSpare()
        game.roll(3)
        rollMany(17, 0)

        assertThat(game.score()).isEqualTo(10 + 3 + 3)
    }

    @Test
    fun `one strike`() {
        rollStrike()
        game.roll(3)
        game.roll(4)
        rollMany(16, 0)
        assertThat(game.score()).isEqualTo(10 + 3 + 4 + 3 + 4)
    }

    @Test
    fun `perfect game`() {
        rollMany(12, 10)
        assertThat(game.score()).isEqualTo(300)
    }

    private fun rollSpare() {
        game.roll(5)
        game.roll(5)
    }

    private fun rollStrike() {
        game.roll(10)
    }
}
