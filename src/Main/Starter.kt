package Main

import javafx.application.Application
import javafx.stage.Stage

class Starter : Application() {
    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        MainStage().show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Starter::class.java)
        }
    }
}