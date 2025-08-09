object CharacterClassification {
    fun isDigit(char: String) = char.toCharArray()[0] in '0'..'9'
    fun isPositive(char: String) = char.toCharArray()[0] in '1'..'9'
    fun isSpecial(char: String) = "!@#$%&*".contains(char.toCharArray()[0])
    fun isCapital(char: String) = char.toCharArray()[0] in 'A' ..'Z'
    fun isBinary(char: String) = char.toCharArray()[0] in '0'..'1'
}