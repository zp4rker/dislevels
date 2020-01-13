package com.zp4rker.dislevels

import com.zp4rker.dislevels.listeners.MessageListener
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.hooks.AnnotatedEventManager

fun main() {
    JDABuilder(AccountType.BOT).run {
        setToken("Mzg3NDQ5MzYxMTExNzExNzU2.DWqOqg.p0bxOU2kKhFtyPDdputuDFTKKHg")
        setEventManager(AnnotatedEventManager())
        addEventListeners(MessageListener())
        build()
    }
}