abstract class RegexChecker<C : RegexChecker<C, S>, S: RegexState<C, S>> : Context<C, S> {
    protected abstract var currentState: S
    override fun validate(string: String): Boolean{
        for (char in string){
            currentState.handle(char.toString(), this as C)
        }
        return isValid()&&otherConstraints(string)
    }
    override fun setState(state: S){
        currentState = state
    }
    protected abstract fun isValid(): Boolean
    open fun otherConstraints(string: String): Boolean{
        return true
    }
}