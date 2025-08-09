import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PasswordTest {

    @Test
    fun `valid passwords return true`() {
        assertTrue(Check.password("aaaaH!aa"))
        assertTrue(Check.password("1234567*9J"))
        assertTrue(Check.password("asdpoihj;loikjasdf;ijp;lij2309jasd;lfkm20ij@aH"))
    }

    @Test
    fun `passwords too short return false`() {
        assertFalse(Check.password("a"))
        assertFalse(Check.password("aaa!Baa"))  // 7 chars only

    }

    @Test
    fun `passwords missing capital letters return false`() {
        assertFalse(Check.password("aaaaaaa!"))
    }

    @Test
    fun `passwords missing special characters return false`() {
        assertFalse(Check.password("aaaHaaaaa"))
    }

    @Test
    fun `passwords ending with special character return false`() {
        assertFalse(Check.password("aaaaaaa!"))
        assertFalse(Check.password("Abbbbbbb!"))
        assertFalse(Check.password("aaa!Ba$"))
        assertFalse(Check.password("aaa!Ba$#"))
    }
}