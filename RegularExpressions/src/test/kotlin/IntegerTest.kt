import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IntegerTest {

    @Test
    fun `valid integers return true`() {
        assertTrue(Check.int("1"))
        assertTrue(Check.int("123"))
        assertTrue(Check.int("3452342352434534524346"))
    }

    @Test
    fun `empty string returns false`() {
        assertFalse(Check.int(""))
    }

    @Test
    fun `integer starting with zero returns false`() {
        assertFalse(Check.int("0123"))
        assertFalse(Check.int("0"))
    }

    @Test
    fun `string containing non-digit returns false`() {
        assertFalse(Check.int("132a"))
        assertFalse(Check.int("12 3"))
        assertFalse(Check.int("1.23"))
        assertFalse(Check.int("abc"))
    }
}