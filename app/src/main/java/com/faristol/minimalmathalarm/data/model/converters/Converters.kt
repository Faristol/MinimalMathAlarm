package com.faristol.minimalmathalarm.data.model.converters

import androidx.room.TypeConverter
import com.faristol.minimalmathalarm.data.model.enums.ProblemType
import com.faristol.minimalmathalarm.data.model.enums.TargetDays

class Converters {
    @TypeConverter
    fun fromTargetDaysList(targetDays: List<TargetDays>): String {
        return targetDays.joinToString(",") { it.name }
    }
    @TypeConverter
    fun toTargetDaysList(data: String): List<TargetDays> {
        return data.split(",").map { TargetDays.valueOf(it) }
    }
    @TypeConverter
    fun fromProblemTypeList(problemType: List<ProblemType>): String {
        return problemType.joinToString(",") { it.name }
    }
    @TypeConverter
    fun toProblemTypeList(data: String): List<ProblemType> {
        return data.split(",").map { ProblemType.valueOf(it) }
    }
}