class PasswordContext : RegexChecker<PasswordContext, PasswordState>() {
    override var currentState: PasswordState = MissingCapitalAndSpecial
    override fun isValid(): Boolean{
        return currentState==ValidPassword
    }
}