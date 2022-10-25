package bot.turingapi.whiter

import bot.turingapi.whiter.data.request.*
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.events.BotEvent
import net.mamoe.mirai.event.events.FriendMessageEvent
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageEvent
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.info

object TuringApiBot : KotlinPlugin(
    JvmPluginDescription(
        id = "bot.turingapi.whiter.bot",
        name = "TuringApiBot",
        version = "0.1.0",
    ) {
        author("whiterasbk")
    }
) {
    override fun onEnable() {
        logger.info { "Turing bot loaded" }

        BotConfiguration.reload()

        CommandManager.registerCommand(BotCommand)

        val channels = globalEventChannel().filter { it is BotEvent }

        channels.subscribeAlways<FriendMessageEvent> {
            handle(BotConfiguration.friendTriggerPrefix)
        }

        channels.subscribeAlways<GroupMessageEvent> {
            handle(BotConfiguration.groupTriggerPrefix)
        }
    }

    private suspend fun MessageEvent.handle(trigger: String) {

        if (message.content.startsWith(trigger)) {
            val (results, intent) = request {
                RequestForm(Perception(
                    InputText(message.content.removePrefix(trigger))),

                    if (this is GroupMessageEvent) UserInfo(
                        sender.id.toString(),
                        groupId = group.id.toString(),
                        userIdName = senderName
                    ) else UserInfo(
                        subject.id.toString(),
                        userIdName = senderName
                    )
                )
            }

            val chain = buildMessageChain {
                results?.forEach {
                    +it.values.text
                }
            }

            if (chain.isNotEmpty()) {
                subject.sendMessage(chain)
            } else {
                subject.sendMessage(intent.toString())
            }
        }

    }
}