package Main

import java.awt.*
import java.io.File

class TrayCreator {
    companion object {
        fun createAndDisplayTray(path: String) {
            val tray = SystemTray.getSystemTray()
            val image: Image = Toolkit.getDefaultToolkit().getImage(path)
            val trayIcon = TrayIcon(image, "Tray Demo")
            trayIcon.isImageAutoSize = true
            trayIcon.toolTip = "ScreenShot done"
            tray.add(trayIcon)
            trayIcon.displayMessage("ScreenShot done", "Screen path - $path", TrayIcon.MessageType.INFO)

            trayIcon.addActionListener {
                val imageFile = File(path)
                if (imageFile.exists()) {
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(imageFile)
                    }
                }
            }
        }
    }
}