package Editor

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.control.ColorPicker
import javafx.scene.control.Slider
import javafx.scene.image.Image
import javafx.stage.Stage
import java.io.File

class EditorStage(path : String) : Stage() {
        private var loader : FXMLLoader = FXMLLoader()

        init {
            loader.location = javaClass.getResource("EditorPage.fxml")
            val mainScene = loader.load<Parent>()
            val controller = loader.getController<EditorPage>()

            val localURL = File(path).toURI().toURL().toString()
            controller.image = Image(localURL)
            controller.canvas = (mainScene.lookup("#Canvas") as Canvas)
            controller.colorPicker = (mainScene.lookup("#ColorPicker") as ColorPicker)
            controller.strokeSlider = (mainScene.lookup("#StrokeSlider") as Slider)
            controller.init()

            scene = Scene(mainScene)
        }
}