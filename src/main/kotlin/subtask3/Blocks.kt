package subtask3

/*
Робот Пафнутий узнал про блоки. И теперь он отказывается работать как-то по другому.

Помоги Пафнутию выполнить простейшие операции с разными типами объектов.

blockA — принимает данные. В блок передается массив разных объектов. Числа, строки, даты.
Массив без данных Пафнутий не принимает.

blockB — принимает данные. В блок передается класс объекта, с которым нужно работать.

blockC — возвращает данные на основе тех, которые были получены в блоках A и B.

В зависимости от принимаемого массива в блоке A и класса в блоке B в блок C возвращается:

Для чисел — сумма всех чисел
Для строк — конкатенация всех строк
Для дат — самая позняя (т.е. ближайшая к текущему дню) дата в виде строки в формате dd.MM.yyyy
blockC вызывается, когда у Пафнутия хватает данных для вычисления

Пример:

В blockA передаем массив [1, "4", 2, "3"]
В blockB передаем класс String
В blockC возвращает "43", так как из массива в блоке А берутся элементы типа String (из блока B) - "4" и "3" -
и происходит их конкатенация
Input:

blockA - cписок с объектами Array одного из трех типов (тип объектов может быть String, Int или LocalDate)
blockB - тип объекта KClass<*>
Output: blockC: Any - результат, согласно условиям описанным выше
* */

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    // TODO: Complete the following function
    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            Int::class -> {
                println(blockA.filterIsInstance<Int>().sum())
                return blockA.filterIsInstance<Int>().sum()
            }
            String::class -> {
                var s = ""
                for (i in blockA.filterIsInstance<String>().indices) {
                    s += blockA.filterIsInstance<String>()[i]
                }
                println(s)

                return s
            }
            LocalDate::class -> {
                val s = mutableListOf<LocalDate>()
                for (i in blockA.filterIsInstance<LocalDate>().indices) {
                    s.add(blockA.filterIsInstance<LocalDate>()[i])
                }

                println(s.max())
                val date1 = LocalDate.parse(s.max().toString())
                val day = date1.dayOfMonth
                val month = date1.monthValue
                val year = date1.year
                println("$day.$month.$year")
                return "$day.$month.$year"
            }
            else -> "error"
        }


    }
}
