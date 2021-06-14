package subtask1

import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.LocalDate

/*1) Date Formatter
    Робот Геннадий, умный робот. Он умеет говорить на правильном русском языке и по
дате определяет день недели. Будь как Геннадий.
    Задача: Реализуйте метод, который по числу, месяцу и году определяет день недели и
возвращает его в правильном падеже.

Пример:
Входные данные: 17 11 2020
Выходная строка: 17 ноября, вторник


Входные данные: 18 3 2019
Выходная строка: 18 марта, понедельник
Входные данные: 29 2 2017

Выходная строка: Такого дня не существует

Input: three parameters - day: String, month: String, year: String
    Output: text representation of Date - "$day $text_month, $text_day_of_the_week"
or "Такого дня не существует"
* */

class DateFormatter {

    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        val monthText: String
        val dayWeek: String
        try {
            val date = LocalDate.of(year.toInt(), month.toInt(), day.toInt())

            monthText = transMonth(month)

            dayWeek = transDay(date.dayOfWeek.toString())

        } catch (e: DateTimeException) {
            println("Такого дня не существует")
            return "Такого дня не существует"
        }
        println("$day $monthText, $dayWeek")
        return "$day $monthText, $dayWeek"
    }

    private fun transDay (day: String): String {
        var dWeek = day
        when (day) {
            "MONDAY" -> dWeek = "понедельник"
            "TUESDAY" -> dWeek = "вторник"
            "WEDNESDAY" -> dWeek = "среда"
            "THURSDAY" -> dWeek = "четверг"
            "FRIDAY" -> dWeek = "пятница"
            "SATURDAY" -> dWeek = "суббота"
            "SUNDAY" -> dWeek = "воскресенье"
        }
        return dWeek
    }

    private fun transMonth (month: String): String {
        var tMonth = month
        when (month) {
            "1" -> tMonth = "января"
            "2" -> tMonth = "февраля"
            "3" -> tMonth = "марта"
            "4" -> tMonth = "апреля"
            "5" -> tMonth = "мая"
            "6" -> tMonth = "июня"
            "7" -> tMonth = "июля"
            "8" -> tMonth = "августа"
            "9" -> tMonth = "сентября"
            "10" -> tMonth = "октября"
            "11" -> tMonth = "ноября"
            "12" -> tMonth = "декабря"
        }
        return tMonth
    }
}
