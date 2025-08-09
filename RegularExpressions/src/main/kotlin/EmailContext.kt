class EmailContext : RegexChecker<EmailContext, EmailState>() {
    override var currentState: EmailState = LookingForPart1
    override fun isValid(): Boolean{
        return currentState==ValidEmail
    }
}