package bot.turingapi.whiter.data.request

import kotlinx.serialization.Serializable

@Serializable
data class Perception(
    val inputText: InputText? = null,
    val inputImage: InputImage? = null,
    val selfInfo: SelfInfo? = null
) {
    init {
        if (inputImage == null && inputText == null)
            throw Exception("输入参数必须包含 inputText 或 inputImage 或 inputMedia")
    }
}