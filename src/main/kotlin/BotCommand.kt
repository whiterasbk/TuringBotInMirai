package bot.turingapi.whiter

import bot.turingapi.whiter.data.request.*
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.message.data.buildMessageChain

object BotCommand : SimpleCommand(
    primaryName = "turingbot",
    secondaryNames = arrayOf("trb"),
    description = "asc", owner = TuringApiBot) {

    @Handler
    suspend fun CommandSender.chat(msg: String) {
        val (results, intent) = request {
            RequestForm(Perception(InputText(msg)), UserInfo(name))
        }

        val chain = buildMessageChain {
            results?.forEach {
                +it.values.text
            }
        }

        if (chain.isNotEmpty()) {
            sendMessage(chain)
        } else {
            sendMessage(intent.toString())
        }

    }
}