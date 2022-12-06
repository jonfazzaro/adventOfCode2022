package rockPaperScissors

import java.lang.reflect.Type

class Scissors() : Shape() {
    override val value = 3
    override val defeats: Type = Paper::class.java
}