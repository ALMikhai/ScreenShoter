package Main

import java.awt.*
import java.awt.TrayIcon.MessageType
import java.io.File

class Controller {
    fun screenShot() {
        val path = ScreenShot.allWindowScreenShot()
        TrayCreator.createAndDisplayTray(path)
    }
}