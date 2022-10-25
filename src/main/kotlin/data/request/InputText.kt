package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class InputText(
    val text: String
)