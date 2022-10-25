package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val userId: String,
    var apiKey: String? = null,
    val groupId: String? = null,
    val userIdName: String? = null
)