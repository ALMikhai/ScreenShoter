package Main

class Controller {
    fun screenShot() {
        val path = ScreenShot.allWindowScreenShot()
        TrayCreator.createAndDisplayTray(path)
    }
}