package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class Parameters(
    val nearby_place: String
)