import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FloatTest {

    @Test
    fun `valid floats return true`() {
        assertTrue(Check.float("1.0"))
        assertTrue(Check.float("123.34"))
        assertTrue(Check.float("0.20000"))
        assertTrue(Check.float("12349871234.12340981234098"))
        assertTrue(Check.float(".123"))
    }

    @Test
    fun `floats without a period return false`() {
        assertFalse(Check.float("123"))
    }

    @Test
    fun `floats with too many periods return false`() {
        assertFalse(Check.float("123.123."))
        assertFalse(Check.float("1.2.3"))
    }

    @Test
    fun `floats with invalid characters return false`() {
        assertFalse(Check.float("123.02a"))
        assertFalse(Check.float("123.a"))
        assertFalse(Check.float("abc.def"))
    }

    @Test
    fun `floats with period not followed by digits return false`() {
        assertFalse(Check.float("123."))
        assertFalse(Check.float("0."))
    }

    @Test
    fun `floats starting with 0 not followed by period return false`() {
        assertFalse(Check.float("012.4"))
        assertFalse(Check.float("01.23"))
    }
}