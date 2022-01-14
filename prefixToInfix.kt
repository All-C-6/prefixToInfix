import java.util.EmptyStackException
import java.util.Stack
import java.util.Scanner

object prefixToInfix {
    @Throws(EmptyStackException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        println("Введите ваше выражение:")
        val prefix = `in`.nextLine().split(" ".toRegex()).toTypedArray()
        val infix: Stack<String> = Stack<String>()
        var a: String
        var b: String
        var c = " "
        try {
            for (i in prefix.indices.reversed()) {
                println(prefix[i])
                when (prefix[i]) {
                    "+" -> {
                        a = infix.pop().toString()
                        b = infix.pop().toString()
                        c = "$a + $b"
                        infix.push(c)
                    }
                    "-" -> {
                        a = infix.pop().toString()
                        b = infix.pop().toString()
                        c = "$a - $b"
                        infix.push(c)
                    }
                    "*" -> {
                        a = infix.pop().toString()
                        b = infix.pop().toString()
                        c =
                            if (a.length > 1 && b.length > 1) "($a) * ($b)" else if (a.length > 1 && b.length == 1) "($a) * $b" else if (a.length == 1 && b.length > 1) "$a * ($b)" else "$a * $b"
                        infix.push(c)
                    }
                    "/" -> {
                        a = infix.pop().toString()
                        b = infix.pop().toString()
                        c =
                            if (a.length > 1 && b.length > 1) " ($a)  /  ($b) " else if (a.length > 1 && b.length == 1) " ($a)  / $b" else if (a.length == 1 && b.length > 1) "$a /  ($b) " else "$a / $b"
                        infix.push(c)
                    }
                    else -> infix.push(prefix[i])
                }
            }
        } catch (e: EmptyStackException) {
            println("Введите корректное выражение")
        }
        System.out.printf("Выражение в инфиксной форме: %s", infix)
    }
}