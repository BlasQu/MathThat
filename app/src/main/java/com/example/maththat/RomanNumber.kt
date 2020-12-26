package com.example.maththat

import java.util.*

object RomanNumber {

    val numbers = TreeMap<Int, String>()

    init {
        numbers[1000] = "M"
        numbers[900] = "CM"
        numbers[500] = "D"
        numbers[400] = "CD"
        numbers[100] = "C"
        numbers[90] = "XC"
        numbers[50] = "L"
        numbers[40] = "XL"
        numbers[10] = "X"
        numbers[9] = "IX"
        numbers[5] = "V"
        numbers[4] = "IV"
        numbers[1] = "I"
    }

    fun ConvertNumber(number: Int): String{
        val keynumber = numbers.floorKey(number)
        if (number == keynumber){
            return numbers[number].toString()
        }
        return numbers[keynumber] + ConvertNumber(number - keynumber)
    }

    fun ConvertRoman(roman: String): Int{
        if (roman.startsWith("M")) {
            return 1000 + ConvertRoman(roman.removePrefix("M"))
        }

        if (roman.startsWith("CM")) {
            return 900 + ConvertRoman(roman.removePrefix("CM"))
        }

        if (roman.startsWith("D")) {
            return 500 + ConvertRoman(roman.removePrefix("D"))
        }

        if (roman.startsWith("CD")) {
            return 400 + ConvertRoman(roman.removePrefix("CD"))
        }

        if (roman.startsWith("C")) {
            return 100 + ConvertRoman(roman.removePrefix("C"))
        }

        if (roman.startsWith("XC")) {
            return 90 + ConvertRoman(roman.removePrefix("XC"))
        }

        if (roman.startsWith("L")) {
            return 50 + ConvertRoman(roman.removePrefix("L"))
        }

        if (roman.startsWith("XL")) {
            return 40 + ConvertRoman(roman.removePrefix("XL"))
        }

        if (roman.startsWith("X")) {
            return 10 + ConvertRoman(roman.removePrefix("X"))
        }

        if (roman.startsWith("IX")) {
            return 9 + ConvertRoman(roman.removePrefix("IX"))
        }

        if (roman.startsWith("V")) {
            return 5 + ConvertRoman(roman.removePrefix("V"))
        }

        if (roman.startsWith("IV")) {
            return 4 + ConvertRoman(roman.removePrefix("IV"))
        }

        if (roman.startsWith("I")) {
            return 1 + ConvertRoman(roman.removePrefix("I"))
        }

        return 0
    }
}