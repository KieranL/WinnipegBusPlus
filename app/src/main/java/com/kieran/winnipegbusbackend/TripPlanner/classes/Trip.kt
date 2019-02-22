package com.kieran.winnipegbusbackend.TripPlanner.classes

import com.kieran.winnipegbusbackend.Route
import com.kieran.winnipegbusbackend.TripPlanner.SegmentFactory

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

class Trip(tripParameters: TripParameters, trip: JSONObject) {
    var times: Times? = null
        private set
    var segments: ArrayList<Segment>
        internal set
    val routes: List<Route>
        get() = segments.mapNotNull { (it as? RideSegment)?.route }


    init {
        segments = ArrayList()
        getSegments(tripParameters, trip)
    }

    private fun getSegments(tripParameters: TripParameters, trip: JSONObject) {
        try {
            val times = trip.getJSONObject("times")
            this.times = Times(times)
            val segmentNodes = trip.getJSONArray("segments")

            (0 until segmentNodes.length())
                    .map { segmentNodes.getJSONObject(it) }
                    .map { SegmentFactory.createSegment(tripParameters, it) }
                    .forEach { segment -> segment?.let { segments.add(it) } }


        } catch (e: JSONException) {

        }
    }

    override fun toString(): String {
        return segments[0].times.startTime!!.to12hrTimeString() + "-" + segments[segments.size - 1].times.endTime!!.to12hrTimeString()
    }
}
