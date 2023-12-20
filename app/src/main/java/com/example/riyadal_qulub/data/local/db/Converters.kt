@file:Suppress("Since15")

package com.example.riyadal_qulub.data.local.db

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.example.riyadal_qulub.domain.model.WeekDays
import java.time.LocalDateTime


object Converters {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        return if (value != null) LocalDateTime.parse(value) else null
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? {
        return date?.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromStringList(value: String?): List<LocalDateTime>? {
        return if (value != null) if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            java.util.List.of(
                *value.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray())
                .stream()
                .map { text: String? ->
                    LocalDateTime.parse(
                        text
                    )
                }
                .toList()
        } else {
            TODO("VERSION.SDK_INT < UPSIDE_DOWN_CAKE")
        } else null
    }

    @TypeConverter
    fun dateListToString(dateList: List<LocalDateTime>?): String? {
        return dateList?.stream()?.map { obj: LocalDateTime -> obj.toString() }
            ?.reduce { s1: String?, s2: String? -> "$s1,$s2" }?.orElse(null)
    }

    @TypeConverter
    fun fromStringListToString(stringList: List<String?>?): String? {
        return if (stringList != null) java.lang.String.join(",", stringList) else null
    }

    @TypeConverter
    fun fromStringToStringList(value: String?): List<String>? {
        return if (value != null) java.util.List.of(
            *value.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()) else null
    }


    @TypeConverter
    fun fromWeekDaysListToString(weekDaysList: List<WeekDays>?): String? {
        return if (weekDaysList != null) java.lang.String.join(
            ",",
            weekDaysList.map { it.name }) else null
    }


    @TypeConverter
    fun fromStringToWeekDaysList(value: String?): List<WeekDays>? {
        return if (value != null) listOf(
            *value.split(",".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()).map { WeekDays.valueOf(it) } else null
    }

}
