class FloatContext : RegexChecker<FloatContext, FloatState>() {
    override var currentState: FloatState = LookingForFirstValueFloat
    override fun isValid(): Boolean{
        return currentState==ValidFloat
    }
}