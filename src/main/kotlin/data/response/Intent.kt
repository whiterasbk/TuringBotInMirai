package bot.turingapi.whiter.data.response

import bot.turingapi.whiter.data.response.Parameters
import kotlinx.serialization.Serializable

@Serializable
data class Intent(
    var appKey: String? = null,
    val code: Int? = null,
    val operateState: Int? = null,
    val actionName: String? = null,
    val intentName: String? = null,
    val parameters: Parameters? = null
)