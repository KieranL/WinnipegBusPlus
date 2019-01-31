package com.kieran.winnipegbusbackend.interfaces

import com.kieran.winnipegbusbackend.StopFeatures
import com.kieran.winnipegbusbackend.StopSchedule
import com.kieran.winnipegbusbackend.StopTime
import com.kieran.winnipegbusbackend.enums.ScheduleType

interface TransitService {
    fun getStopSchedule(stop: StopIdentifier, startTime: StopTime?, endTime: StopTime?, routes: List<RouteIdentifier> = ArrayList()): StopSchedule

    fun getStopDetails(stop: StopIdentifier, stopFeatures: StopFeatures): StopFeatures

    fun getRouteStops(route: RouteIdentifier)

    fun findStop(name: String)

    fun findClosestStops(location: Location, distance:Int = 1000, stopCount: Int = 1)

    fun getLastQueryTime(): StopTime

    fun getScheduleType(): ScheduleType
}