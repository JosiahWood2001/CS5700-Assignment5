class IntegerContext : RegexChecker<IntegerContext, IntegerState>() {
    override var currentState: IntegerState = LookingForFirstValue
    override fun isValid(): Boolean{
        return currentState==Valid
    }
}