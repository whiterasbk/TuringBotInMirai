package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class InputImage(
    val url: String
)