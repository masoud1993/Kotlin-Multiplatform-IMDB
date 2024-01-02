import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.masa.kmptutorial.cache.DriverFactory

fun main() = application {
    SDK.init(DriverFactory())
    Window(onCloseRequest = ::exitApplication, title = "KmpTutorial") {
        App()
    }
}

@Preview
@Composable
fun AppDesktopPreview() {
    App()
}