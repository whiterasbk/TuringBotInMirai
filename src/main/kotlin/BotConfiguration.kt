package bot.turingapi.whiter

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

object BotConfiguration : AutoSavePluginConfig("config") {
    @ValueDescription("前往 http://www.turingapi.com/ 获取")
    val appKey: String by value()
    @ValueDescription("私聊触发前缀")
    val friendTriggerPrefix: String by value("  ")
    @ValueDescription("群聊触发前缀")
    val groupTriggerPrefix: String by value("  ")
}