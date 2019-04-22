package com.gaussboy.cyphxor
/**
 * Вариант 2 — шифрация
 * Шифрация (-c) или дешифрация (-d) указанного (в аргументе командной строки) файла.
 * Выходной файл указывается как -o filename.txt, по умолчанию имя формируется из имени входного файла с добавлением расширения.
 * Алгоритм шифрации XOR. Ключ указывается после -c или -d в шестнадцатеричной системе, длина ключа — любое целое количество байт.
 *
 * Command Line: ciphxor [-c key] [-d key] inputname.txt [-o outputname.txt]
 *
 * */


fun main(args: Array<String>) {
    var inputName = ""
    var outputName = ""
    var key = ""


    if (args.isEmpty()) {
        printHelp()
    } else {
        //ideal
        // 0 - (-c/-d)  1 - (key)  2 - (inputName)  3 - (-o)  4 - (outputName)
        for (i in 0 until args.size) {
            if (args[i] == "-c" || args[i] == "-d") {
                key = args[i + 1]
                inputName = args[i+2]
            }
            if (args[i] == "-o") {
                outputName = args[i+1]
            }
        }
        nyx(inputName, outputName, key)

    }
}

fun printHelp() {
    println("")
}