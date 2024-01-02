import androidx.compose.ui.window.ComposeUIViewController
import com.masa.kmptutorial.cache.DriverFactory

fun MainViewController() = ComposeUIViewController {
    SDK.init(DriverFactory())
    App()
}
