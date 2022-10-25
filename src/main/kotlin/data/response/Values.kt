package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class Values(
    val text: String,
    val url: String? = null
)