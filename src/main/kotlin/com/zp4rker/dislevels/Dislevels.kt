package com.zp4rker.dislevels

import com.zp4rker.core.discord.command.Command
import com.zp4rker.core.discord.command.CommandHandler
import com.zp4rker.dislevels.listeners.MessageListener
import net.dv8tion.jda.api.AccountType
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.hooks.AnnotatedEventManager
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.math.pow

fun main() {
    /*with(JDABuilder(AccountType.BOT)) {
        setToken("TOKEN")
        setEventManager(AnnotatedEventManager())
        addEventListeners(MessageListener())
    }.build()*/

    Database.connect("jdbc:mysql://localhost:3306/testing", driver = "com.mysql.jdbc.Driver", user = "root", password = "YojiVoki2!Yaje")
    val y = 4.0
    // √3 * √(3888y^2 - 6512400y - 191009089) + 108y - 90450
    val lpt = (3.0.pow(1/2) * (3888 * y.pow(2) - 6512400 * y - 191009089).pow(1/2) + 108 * y - 90450).pow(1/3)

    val pt1 = lpt / (2 * 3.0.pow(2/3))
    val pt2 = 1429 / (2 * 3.0.pow(1/3) * lpt)
    val pt3 = 25 / 2.0

    println("answer for y=$y -> ${pt1 + pt2 - pt3}")

    TODO("add config and make libraries download")
}