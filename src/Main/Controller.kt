package Main

import Editor.EditorStage

class Controller {
    fun screenShot() {
        val path = ScreenShot.allWindowScreenShot()
        val editorWindow = EditorStage(path) // EditWindow
        editorWindow.showAndWait()
    }
}