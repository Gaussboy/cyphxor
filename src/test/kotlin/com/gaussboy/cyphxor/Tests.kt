package com.gaussboy.cyphxor

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

class Tests {
    @Test
    fun test1() {
        val args = arrayOf("-c", "A", "testsfiles/input.txt", "-o", "testsfiles/output.txt")
        main(args)
        val etalon = File("testsfiles/etalon.txt").readLines()
        val output = File("testsfiles/output.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun test2() {
        val args = arrayOf("-d", "A", "testsfiles/input1.txt", "-o", "testsfiles/output1.txt")
        main(args)
        val etalon = File("testsfiles/etalon1.txt").readLines()
        val output = File("testsfiles/output1.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun test3() {
        val args = arrayOf("-c", "A", "testsfiles/input2.txt", "-o", "testsfiles/output2.txt")
        main(args)
        val etalon = File("testsfiles/etalon2.txt").readLines()
        val output = File("testsfiles/output2.txt").readLines()
        assertEquals(etalon, output)
    }

    @Test
    fun encPlusDec() {
        val args = arrayOf("-c", "B12CF", "testsfiles/input.txt", "-o", "testsfiles/output4.txt")
        val args2 = arrayOf("-c", "B12CF", "testsfiles/output4.txt", "-o", "testsfiles/input4.txt")
        main(args)
        main(args2)
        val etalon = File("testsfiles/input.txt").readLines()
        val actual = File("testsfiles/input4.txt").readLines()
        assertEquals(etalon, actual)
    }
}