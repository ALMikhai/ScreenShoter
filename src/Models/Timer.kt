package Models

import java.util.*

class Timer(seconds : Double) {
    init {
        val timeNow = Date()
        val unixDuration = seconds * 1000

        while ((Date().time - timeNow.time) <= unixDuration){
        }
    }
}