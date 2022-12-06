package rockPaperScissors

import java.lang.reflect.Type

class Paper() : Shape() {
    override val value = 2
    override val defeats: Type = Rock::class.java
}