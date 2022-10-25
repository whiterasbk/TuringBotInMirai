package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class UserEmotion(
    val a: Int? = null,
    val d: Int? = null,
    val emotionId: Int? = null,
    val p: Int? = null
)