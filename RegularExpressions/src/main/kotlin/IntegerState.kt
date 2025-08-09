abstract class IntegerState : RegexState<IntegerContext, IntegerState>() {
    abstract override fun handle(character: String, context: IntegerContext)
}
object LookingForFirstValue : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {

    }
}
object Valid : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {

    }
}
object Invalid : IntegerState(){
    override fun handle(character: String, context: IntegerContext) {

    }
}
