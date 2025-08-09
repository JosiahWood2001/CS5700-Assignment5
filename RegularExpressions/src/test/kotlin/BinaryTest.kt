import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinaryTest {

    @Test
    fun `valid binary numbers return true`() {
        assertTrue(Check.binary("1"))
        assertTrue(Check.binary("11"))
        assertTrue(Check.binary("101"))
        assertTrue(Check.binary("111111"))
        assertTrue(Check.binary("10011010001"))
    }

    @Test
    fun `binary numbers not starting with 1 return false`() {
        assertFalse(Check.binary("01"))
        assertFalse(Check.binary("0"))
        assertFalse(Check.binary("001"))
    }

    @Test
    fun `binary numbers not ending with 1 return false`() {
        assertFalse(Check.binary("10"))
        assertFalse(Check.binary("1000010"))
        assertFalse(Check.binary("1100"))
    }

    @Test
    fun `binary numbers containing invalid characters return false`() {
        assertFalse(Check.binary("100a01"))
        assertFalse(Check.binary("10102"))
        assertFalse(Check.binary("abc"))
        assertFalse(Check.binary("1001a"))
    }
}