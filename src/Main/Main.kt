package Main

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {
    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("MainWindow.fxml")
        val mainParent = loader.load<Parent>()
        primaryStage.scene = Scene(mainParent)
        primaryStage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}