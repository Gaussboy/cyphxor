package com.gaussboy.cyphxor

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import kotlin.experimental.xor


fun nyx(input: String, output: String, key: String) {
    val inputText = File(input).readLines()
    val outputFile = File(output)
    val result: List<String>
    result = cypher(inputText, key)
    val writer = BufferedWriter(FileWriter(outputFile, true))
    for (i in result)
        writer.write(i)
    writer.close()
}

fun cypher(text: List<String>, key: String ) : List<String> {
    val result = mutableListOf<String>()
    for (i in 0 until text.size) {
        val txt = text[i].toByteArray(Charsets.UTF_8)
        val key = key.toByteArray(Charsets.UTF_8)
        val res = ByteArray(txt.size)
        for (j in 0 until txt.size - 1) {
            res[j] = (txt[j] xor key[j % key.size])
        }
        result.add(String(res, Charsets.UTF_8))
    }
    return result
}
