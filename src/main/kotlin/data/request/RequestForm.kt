package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestForm(
    val perception: Perception,
    val userInfo: UserInfo,
    val reqType: Int? = null
)