class BinaryContext : RegexChecker<BinaryContext, BinaryState>() {
    override var currentState: BinaryState = LookingForFirst1
    override fun isValid(): Boolean{
        return currentState==ValidBinary
    }
}