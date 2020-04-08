package com.zp4rker.dislevels

import kotlin.math.pow

object Levels {

    fun nextLevelExp(level: Int) = 2L * (level * level + 24 * level + 25)

    fun levelsToExp(level: Int): Long {
        return ((2 * level.toDouble().pow(3) + 3 * level.toDouble().pow(2) + level) / 6 + 12 * level.toDouble().pow(2) + 37 * level).toLong()
    }

    fun expToLevels(exp: Long): Int {
        var level = 0

        while (true) {
            val nextExp = nextLevelExp(level + 1)
            if (exp < nextExp) return level
            level++
        }
    }

    fun remainingExp(exp: Long): Long {
        
    }

}