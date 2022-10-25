package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class SelfInfo(
    val location: Location? = null
)