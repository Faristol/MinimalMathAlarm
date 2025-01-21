package com.faristol.minimalmathalarm.data.model.enums

enum class ProblemDifficulty {
    EASY, MEDIUM, HARD
}

enum class ProblemType {
    SUM, SUBTRACTION, MULTIPLICATION, DIVISION, MIXED
}

enum class TargetDays {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

fun TargetDays.toFriendlyName(): String {
    return when (this) {
        TargetDays.MONDAY -> "MON"
        TargetDays.TUESDAY -> "TUES"
        TargetDays.WEDNESDAY -> "WED"
        TargetDays.THURSDAY -> "THURS"
        TargetDays.FRIDAY -> "FRI"
        TargetDays.SATURDAY -> "SAT"
        TargetDays.SUNDAY -> "SUN"
    }
}