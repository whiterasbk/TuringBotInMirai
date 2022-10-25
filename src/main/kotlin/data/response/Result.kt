package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val groupType: Int? = null,
    val resultType: String,
    val values: Values
)