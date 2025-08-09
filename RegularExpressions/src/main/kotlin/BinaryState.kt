abstract class BinaryState : RegexState<BinaryContext, BinaryState>() {
    abstract override fun handle(character: String, context: BinaryContext)
}
object LookingForFirstValue : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
        if (CharacterClassification.isBinary(character)){
            context.setState(ValidBinary)
        }
        else{
            context.setState(InvalidBinary)
            }
    }
}
object ValidBinary : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
        if (!CharacterClassification.isBinary(character)){
            context.setState(InvalidBinary)
        }
    }
}
object InvalidBinary : BinaryState(){
    override fun handle(character: String, context: BinaryContext) {
    }
}
