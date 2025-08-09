class Check {
    fun int(string: String): Boolean{
        return IntegerContext().validate(string)
    }
    fun float(string: String): Boolean{
        return FloatContext().validate(string)
    }
    fun binary(string: String): Boolean{
        return BinaryContext().validate(string)
    }
    fun email(string: String): Boolean{
        return EmailContext().validate(string)
    }
    fun password(string: String): Boolean{
        return PasswordContext().validate(string)
    }
}