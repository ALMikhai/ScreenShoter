package Main

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.CheckBox
import javafx.scene.control.Slider
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage

class MainStage : Stage() {
    private var loader : FXMLLoader = FXMLLoader()

    init {
        loader.location = javaClass.getResource("MainWindow.fxml")
        val mainScene = loader.load<Parent>()
        val controller = loader.getController<MainController>()

        controller.pane = (mainScene.lookup("#MainPane") as AnchorPane)
        controller.isWindowClosing = (mainScene.lookup("#WindowClosing") as CheckBox)
        controller.durationSlider = (mainScene.lookup("#DurationSlider") as Slider)

        scene = Scene(mainScene)
        controller.thisStage = this
    }
}