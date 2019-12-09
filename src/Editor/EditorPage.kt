package Editor

import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.ColorPicker
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color

class EditorPage {
    lateinit var canvas: Canvas
    lateinit var image: Image
    lateinit var colorPicker : ColorPicker

    lateinit var graphicsContext: GraphicsContext

    private val canvasOnMousePressed = EventHandler<MouseEvent>() {
        graphicsContext.beginPath()
        graphicsContext.moveTo(it.x, it.y)
        graphicsContext.stroke()
    }

    private val canvasOnMouseDragged = EventHandler<MouseEvent>() {
        graphicsContext.lineTo(it.x, it.y)
        graphicsContext.stroke()
    }

    fun init() {
        graphicsContext = canvas.graphicsContext2D
        graphicsContext.drawImage(image, 0.0, 0.0, canvas.width, canvas.height)
        graphicsContext.stroke = colorPicker.value
        graphicsContext.lineWidth = 10.0

        canvas.onMousePressed = canvasOnMousePressed
        canvas.onMouseDragged = canvasOnMouseDragged
    }

    fun onColorChange() {
        graphicsContext.stroke = colorPicker.value
    }
}