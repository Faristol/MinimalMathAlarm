package com.faristol.minimalmathalarm

import com.faristol.minimalmathalarm.data.model.enums.ProblemDifficulty
import com.faristol.minimalmathalarm.data.model.enums.ProblemType


data class CardInfo(
    var alarmTime: String = "08:00",
    val problemDifficulty: ProblemDifficulty = ProblemDifficulty.EASY,
    val problemType: ProblemType = ProblemType.SUM,
    val problemQuantity: Int = 5,
    val isActive : Boolean = true
)