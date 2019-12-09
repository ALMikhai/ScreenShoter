package Editor

import javafx.scene.canvas.Canvas
import javafx.scene.image.Image

class EditorPage {
    lateinit var canvas: Canvas
    lateinit var image: Image

    fun init() {
        canvas.graphicsContext2D.drawImage(image, 0.0, 0.0, canvas.width, canvas.height)
    }
}