abstract class RegexState<C : RegexChecker<C, S>, S: RegexState<C, S>> : State<C, S> {
    abstract override fun handle(character: String, context: C)
}