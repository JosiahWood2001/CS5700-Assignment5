abstract class EmailState : RegexState<EmailContext, EmailState>() {
    abstract override fun handle(character: String, context: EmailContext)
}
object LookingForPart1 : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (" @".contains(character)){
            context.setState(InvalidEmail)
        }
        else{
            context.setState(Part1)
        }
    }
}
object Part1 : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (character == " "){
            context.setState(InvalidEmail)
        }
        else if (character == "@"){
            context.setState(LookingForPart2)
        }
    }
}
object LookingForPart2 : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (" @.".contains(character)){
            context.setState(InvalidEmail)
        }
        else{
            context.setState(Part2)
        }
    }
}
object Part2 : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (" @".contains(character)){
            context.setState(InvalidEmail)
        }
        else if (character == "."){
            context.setState(LookingForPart3)
        }
    }
}
object LookingForPart3 : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (" @.".contains(character)){
            context.setState(InvalidEmail)
        }
        else{
            context.setState(ValidEmail)
        }
    }
}
object ValidEmail : EmailState(){
    override fun handle(character: String, context: EmailContext) {
        if (" @.".contains(character)){
            context.setState(InvalidEmail)
        }
    }
}
object InvalidEmail : EmailState(){
    override fun handle(character: String, context: EmailContext) {

    }
}