import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EmailTest {

    @Test
    fun `valid emails return true`() {
        assertTrue(Check.email("a@b.c"))
        assertTrue(Check.email("joseph.ditton@usu.edu"))
        assertTrue(Check.email("{}*$.&$*(@*$%&.*&*"))
    }

    @Test
    fun `emails with empty part1 return false`() {
        assertFalse(Check.email("@b.c"))
    }

    @Test
    fun `emails with multiple at symbols return false`() {
        assertFalse(Check.email("a@b@c.com"))
    }

    @Test
    fun `emails with multiple periods after at symbol return false`() {
        assertFalse(Check.email("a.b@b.b.c"))
        assertFalse(Check.email("user@domain.co.uk")) // multiple periods after @
    }

    @Test
    fun `emails containing spaces return false`() {
        assertFalse(Check.email("joseph ditton@usu.edu"))
        assertFalse(Check.email("a @b.c"))
        assertFalse(Check.email("a@b .c"))
    }

    @Test
    fun `emails with empty parts return false`() {
        assertFalse(Check.email("a@.c"))  // part2 empty
        assertFalse(Check.email("a@b."))  // part3 empty
        assertFalse(Check.email("a@b"))   // missing part3
        assertFalse(Check.email("a@b.c."))// trailing dot
    }
}