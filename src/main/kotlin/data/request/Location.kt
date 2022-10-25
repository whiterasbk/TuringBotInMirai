package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val province: String? = null,
    val street: String? = null
)