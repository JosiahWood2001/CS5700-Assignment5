class IntegerContext : RegexChecker<IntegerContext, IntegerState>() {
    override var currentState: IntegerState = LookingForFirstValueInteger
    override fun isValid(): Boolean{
        return currentState==ValidInteger
    }
}