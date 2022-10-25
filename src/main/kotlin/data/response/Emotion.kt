package bot.turingapi.whiter.data.response

import kotlinx.serialization.Serializable

@Serializable
data class Emotion(
    val robotEmotion: RobotEmotion? = null,
    val userEmotion: UserEmotion? = null
)