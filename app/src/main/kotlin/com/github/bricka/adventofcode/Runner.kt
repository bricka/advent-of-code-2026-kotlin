package com.github.bricka.adventofcode

import com.github.bricka.adventofcode.solution.Solution
import java.io.File

object Runner {
    @JvmStatic
    fun main(args: Array<String>) {
        val (dayString, part, inputPathString) = args
        val day = dayString.toInt()

        val input = File(inputPathString).readText()

        val solution = checkNotNull(solutions.find { it.day == day }) { "No solution for day $day" }
        val output =
            when (part) {
                "1" -> solution.part1(input)
                "2" -> solution.part2(input)
                else -> throw IllegalArgumentException("Invalid part: $part")
            }

        println(output)
    }

    private val solutions: Set<Solution> = setOf()
}
