package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseForm(
    val results: List<Result>? = null,
    val intent: Intent,
    val emotion: Emotion? = null
)