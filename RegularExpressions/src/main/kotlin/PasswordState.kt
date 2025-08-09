abstract class PasswordState : RegexState<PasswordContext, PasswordState>() {
    abstract override fun handle(character: String, context: PasswordContext)
}
object MissingCapitalAndSpecial : PasswordState(){
    override fun handle(character: String, context: PasswordContext) {
        if (CharacterClassification.isCapital(character)){
            context.setState(MissingSpecial)
        }
        else if (CharacterClassification.isSpecial(character)){
            context.setState(MissingCapital)
        }
    }
}
object MissingSpecial : PasswordState(){
    override fun handle(character: String, context: PasswordContext) {
        if (CharacterClassification.isSpecial(character)){
            context.setState(ValidPassword)
        }
    }
}
object MissingCapital : PasswordState(){
    override fun handle(character: String, context: PasswordContext) {
        if (CharacterClassification.isCapital(character)){
            context.setState(ValidPassword)
        }
    }
}
object ValidPassword : PasswordState(){
    override fun handle(character: String, context: PasswordContext) {
    }
}