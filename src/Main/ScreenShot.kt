package Main

import java.awt.Rectangle
import java.awt.Robot
import java.awt.Toolkit
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.filechooser.FileSystemView

class ScreenShot {
    companion object {
        fun allWindowScreenShot() : String{
            val path = "${getHomeDir()}\\screen.png"
            ImageIO.write(grubScreen(), "png", File(path))
            return path
        }

        private fun grubScreen() : BufferedImage {
            return Robot().createScreenCapture(Rectangle(Toolkit.getDefaultToolkit().screenSize))
        }

        private fun getHomeDir() : File {
            val fsv = FileSystemView.getFileSystemView()
            return fsv.homeDirectory
        }
    }
}