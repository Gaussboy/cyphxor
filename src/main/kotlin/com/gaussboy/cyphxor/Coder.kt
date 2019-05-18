package com.gaussboy.cyphxor

import java.io.File
import java.lang.Math.abs

class Coder {

    fun encode(input: String, output: String, key: String) {
        val writer = File(output).bufferedWriter()
        val text = File(input).readLines()
        val key2 = key.toInt(16).toString(2)
        val key2CharArray = key2.toCharArray()
        for (line in text) {
            val words = mutableListOf<String>()
            val listOfWords = line.split(" ")
            for (part in listOfWords) {
                val letters = part.toCharArray()
                val listOfLetters = mutableListOf<Char>()
                for (letter in letters) {
                    val letter2 = letter.toInt().toString(2)
                    val letter2CharArray = letter2.toCharArray()
                    val list2 = translator(letter2CharArray, key2CharArray)
                    listOfLetters.add(list2.joinToString(separator = "").toInt(2).toChar())
                }
                words.add(listOfLetters.joinToString(separator = ""))
            }
            writer.write(words.joinToString(separator = " "))
            writer.newLine()
        }
        writer.close()
    }

    private fun translator(pOSC: CharArray, pOSK: CharArray): List<String> { //partOfStringKey == pOSK
        return when {
            pOSC.size > pOSK.size -> {
                val rStr = revertString(pOSK, pOSC)
                sumXOR(rStr, pOSC)
            }
            pOSC.size < pOSK.size -> {
                val rStr = revertString(pOSC, pOSK)
                sumXOR(rStr, pOSK)
            }
            else -> sumXOR(pOSC, pOSK)
        }
    }

    private fun revertString(pOSC1: CharArray, pOSC2: CharArray): CharArray { //partOfStringChar == pOSC
        val diff = abs(pOSC1.size - pOSC2.size)
        var rStr = pOSC1.reversedArray()
        for (i in 0 until diff) rStr += '0'
        return rStr.reversedArray()
    }

    private fun sumXOR(EqualCharString: CharArray, pOS: CharArray): MutableList<String> { //partOfString == pOS
        val list = mutableListOf<String>()
        for (elements in 0 until EqualCharString.size) {
            val sumXOR = ((EqualCharString[elements].toInt() + pOS[elements].toInt()) % 2).toString()
            list.add(sumXOR)
        }
        return list
    }
}