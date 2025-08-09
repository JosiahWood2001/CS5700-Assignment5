class PasswordContext : RegexChecker<PasswordContext, PasswordState>() {
    override var currentState: PasswordState = MissingCapitalAndSpecial
    override fun isValid(): Boolean{
        return currentState==ValidPassword
    }
    override fun otherConstraints(string: String): Boolean {
        return string.length>=8
    }
}