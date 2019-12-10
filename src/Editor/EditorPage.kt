package Editor

import Main.ScreenShot
import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.scene.SnapshotParameters
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.ColorPicker
import javafx.scene.control.Slider
import javafx.scene.image.Image
import javafx.scene.image.WritableImage
import javafx.scene.input.MouseEvent
import java.io.File
import java.util.*
import javax.imageio.ImageIO


class EditorPage {
    lateinit var canvas: Canvas
    lateinit var image: Image
    lateinit var colorPicker : ColorPicker
    lateinit var strokeSlider : Slider

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
        onColorChange()
        onStrokeChange()

        canvas.onMousePressed = canvasOnMousePressed
        canvas.onMouseDragged = canvasOnMouseDragged

        strokeSlider.valueChangingProperty().addListener { _, _, _ ->
            onStrokeChange()
        }
    }

    fun onColorChange() {
        graphicsContext.stroke = colorPicker.value
    }

    private fun onStrokeChange() {
        graphicsContext.lineWidth = strokeSlider.value
    }

    fun saveImage() {
        val parameters = SnapshotParameters()
        val wi = WritableImage(canvas.width.toInt(), canvas.height.toInt())
        val snapshot: WritableImage = canvas.snapshot(SnapshotParameters(), wi)


        val output = File("${ScreenShot.getHomeDir()}\\snapshot_${Date().time}.png")
        ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", output)
    }
}