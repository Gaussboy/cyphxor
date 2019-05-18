package com.gaussboy.cyphxor

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Tests {
    @Test
    fun test1() {
        val args = arrayOf("-c", "A", "input.txt", "-o", "output.txt")
        main(args)
        val etalon = File("etalon.txt").readLines()
        val output = File("output.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun test2() {
        val args = arrayOf("-d", "A", "input1.txt", "-o", "output1.txt")
        main(args)
        val etalon = File("etalon1.txt").readLines()
        val output = File("output1.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun test3() {
        val args = arrayOf("-c", "A", "input2.txt", "-o", "output2.txt")
        main(args)
        val etalon = File("etalon2.txt").readLines()
        val output = File("output2.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun encPlusDec() {
        val args = arrayOf("-c", "B12CF", "input.txt", "-o", "output4.txt")
        val args2 = arrayOf("-c", "B12CF", "output4.txt", "-o", "input4.txt")
        main(args)
        main(args2)
        val etalon = File("input.txt").readLines()
        val actual = File("input4.txt").readLines()
        assertEquals(etalon, actual)
    }
}