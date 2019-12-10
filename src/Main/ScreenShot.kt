package Main

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class ScreenShot {
    companion object {
        fun allWindowScreenShot() : String{
            val path = "screenTmp.png"
            ImageIO.write(grubScreen(), "png", File(path))
            return path
        }

        private fun grubScreen() : BufferedImage {
            return Robot().createScreenCapture(Rectangle(Toolkit.getDefaultToolkit().screenSize))
        }
    }
}