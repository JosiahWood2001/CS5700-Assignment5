class BinaryContext : RegexChecker<BinaryContext, BinaryState>() {
    override var currentState: BinaryState = LookingForFirstValue
    override fun isValid(): Boolean{
        return currentState==ValidBinary
    }
}