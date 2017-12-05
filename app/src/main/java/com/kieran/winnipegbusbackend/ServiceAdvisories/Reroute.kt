package com.kieran.winnipegbusbackend.ServiceAdvisories

import java.io.Serializable

class Reroute(val heading: String, val instructions: List<String>) : Serializable {

    override fun toString(): String {
        return heading + "\n" + instructions.toString() + "\n"
    }
}
