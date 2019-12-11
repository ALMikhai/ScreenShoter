package Main

import Editor.EditorStage
import javafx.scene.control.CheckBox
import javafx.scene.control.Slider
import javafx.scene.layout.AnchorPane
import javafx.stage.Stage
import Models.Timer

class MainController {
    lateinit var isWindowClosing : CheckBox
    lateinit var pane : AnchorPane
    lateinit var thisStage : Stage
    lateinit var durationSlider: Slider

    fun screenShot() {
        if (isWindowClosing.isSelected)
            thisStage.hide()

        Timer(
                if (durationSlider.value != 0.0) {
                    durationSlider.value
                } else {
                    0.5
                }
        )

        val path = ScreenShot.allWindowScreenShot()
        val editorWindow = EditorStage(path) // EditWindow

        if (isWindowClosing.isSelected)
            thisStage.show()

        editorWindow.show()
    }
}