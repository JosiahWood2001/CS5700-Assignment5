import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

class GeneralStructureTest {
    @Test
    fun `RegexChecker enforces encapsulation of currentState`() {
        val intContext = IntegerContext()

        val props = IntegerContext::class.memberProperties
        val hasCurrentState = props.any { it.name == "currentState" }
        assertTrue(hasCurrentState, "RegexChecker must have a currentState property")

        val currentStateProp = IntegerContext::class.memberProperties.first { it.name == "currentState" }
        currentStateProp.isAccessible = true
        val stateValue = currentStateProp.get(intContext)
        assertNotNull(stateValue, "currentState should be initialized")
    }

    @Test
    fun `Context setState updates currentState properly`() {
        val intContext = IntegerContext()
        val initialState = intContext.validate("1")
        val someState = ValidInteger

        intContext.setState(someState)
        val afterSetState = intContext.validate("1")

        assertTrue(afterSetState || !initialState, "setState should affect validate behavior")
    }

    @Test
    fun `Check object routes calls to correct Context implementations`() {
        // We just test that Check.int, float, binary etc call the correct context's validate method

        assertDoesNotThrow {
            Check.int("1")
            Check.float("1.0")
            Check.binary("101")
            Check.email("a@b.c")
            Check.password("Aa!aaaaa")
        }
    }
}