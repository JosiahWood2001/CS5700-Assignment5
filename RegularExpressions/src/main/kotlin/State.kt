interface State<C: Context<C, S>, S :State<C, S>> {
    fun handle(character: String, context: C)
}