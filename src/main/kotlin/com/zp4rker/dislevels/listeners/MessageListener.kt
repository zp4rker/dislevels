package com.zp4rker.dislevels.listeners

import com.zp4rker.dislevels.UserData
import net.dv8tion.jda.api.entities.MessageType
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.SubscribeEvent
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.schedule
import kotlin.random.Random

class MessageListener {

    companion object {
        val userDatas = mutableMapOf<String, UserData>()
        val cooldown = mutableListOf<String>()
    }

    @SubscribeEvent
    fun onMessage(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return
        if (cooldown.contains(event.author.id)) return
        if (event.message.type != MessageType.DEFAULT) return

        val random = Random.nextInt(10) + 16

        if (userDatas.containsKey(event.author.id)) {
            val data = userDatas[event.author.id]!!
            data.experience += random
            userDatas.replace(event.author.id, data)
        } else {
            val data = UserData(event.author.id, event.guild.id).apply { experience += random }
            userDatas[event.author.id] = data
        }

        event.channel.sendMessage("${event.author.name} now has ${userDatas[event.author.id]!!.experience} xp!").queue()


        cooldown.add(event.author.id)
        Timer().schedule(TimeUnit.MINUTES.toMillis(1)) { cooldown.remove(event.author.id) }
    }

}