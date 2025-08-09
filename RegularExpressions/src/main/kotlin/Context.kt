interface Context<C: Context<C, S>, S :State<C, S>> {
    fun setState(state: S)
    fun validate(string: String): Boolean
}