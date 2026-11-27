package com.github.bricka.adventofcode

import com.github.bricka.adventofcode.solution.Solution
import java.io.File

object Runner {
    @JvmStatic
    fun main(args: Array<String>) {
        val (day, part, inputPathString) = args

        val input = File(inputPathString).readText()

        val solution = findSolutionForDay(day.toInt())
        val output =
            when (part) {
                "1" -> solution.part1(input)
                "2" -> solution.part2(input)
                else -> throw IllegalArgumentException("Invalid part: $part")
            }

        println(output)
    }

    private fun findSolutionForDay(day: Int): Solution {
        val solutionsForDay = solutions.filter { it.day == day }
        require(solutionsForDay.size <= 1) {
            "More than one solution for day $day"
        }
        return requireNotNull(solutions.singleOrNull()) {
            "No solution for day $day"
        }
    }

    private val solutions: Set<Solution> = setOf()
}
