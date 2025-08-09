abstract class BinaryState : RegexState<BinaryContext, BinaryState>() {
    abstract override fun handle(character: String, context: BinaryContext)
}
object LookingForFirst1 : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
        if (character=="1"){
            context.setState(ValidBinary)
        }
        else{
            context.setState(InvalidBinary)
        }
    }
}
object LookingForLast1 : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
        if (character=="1"){
            context.setState(ValidBinary)
        }
        else if (character!="0"){
            context.setState(InvalidBinary)
        }
    }
}
object ValidBinary : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
        if (character == "0"){
            context.setState(LookingForLast1)
        }
        else if (character!="1"){
            context.setState(InvalidBinary)
        }
    }
}
object InvalidBinary : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
    }
}
