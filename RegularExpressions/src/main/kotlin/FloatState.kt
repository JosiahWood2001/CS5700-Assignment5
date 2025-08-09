abstract class FloatState : RegexState<FloatContext, FloatState>() {
    abstract override fun handle(character: String, context: FloatContext)
}
object LookingForFirstValueFloat : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (CharacterClassification.isPositive(character)){
            context.setState(StartingWithDigits)
        }
        else if (character == "0"){
            context.setState(StartedWith0)
        }
        else if (character == "."){
            context.setState(StartedWithPeriod)
        }
        else{
            context.setState(InvalidFloat)
        }
    }
}
object ValidFloat : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (!CharacterClassification.isDigit(character)){
            context.setState(InvalidFloat)
        }
    }
}
object InvalidFloat : FloatState(){
    override fun handle(character: String, context: FloatContext) {
    }
}
object StartingWithDigits : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (CharacterClassification.isDigit(character)){
            return
        }
        else if (character == "."){
            context.setState(DecimalPoint)
        }
        else{
            context.setState(InvalidFloat)
        }
    }
}
object StartedWithPeriod : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (CharacterClassification.isDigit(character)){
            context.setState(ValidFloat)
        }
        else{
            context.setState(InvalidFloat)
        }
    }
}
object StartedWith0 : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (character == "."){
            context.setState(DecimalPoint)
        }
        else{
            context.setState(InvalidFloat)
        }
    }
}
object DecimalPoint : FloatState(){
    override fun handle(character: String, context: FloatContext) {
        if (CharacterClassification.isDigit(character)){
            context.setState(ValidFloat)
        }
        else{
            context.setState(InvalidFloat)
        }
    }
}