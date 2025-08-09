abstract class IntegerState : RegexState<IntegerContext, IntegerState>() {
    abstract override fun handle(character: String, context: IntegerContext)
}
object LookingForFirstValueInteger : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {
        if (CharacterClassification.isPositive(character)){
            context.setState(ValidInteger)
        }
        else {
            context.setState(InvalidInteger)
        }
    }
}
object ValidInteger : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {
        if (!CharacterClassification.isDigit(character)){
            context.setState(InvalidInteger)
        }
    }
}
object InvalidInteger : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {
    }
}
