package com.zp4rker.dislevels

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserData(val userId: String, serverId: String) {

    private val table = Users(serverId)

    var experience = 0L

    init {
        transaction {
            addLogger(StdOutSqlLogger)

            SchemaUtils.create(table)

            table.select { table.id eq userId }.toList().apply {
                if (isNotEmpty()) experience = first()[table.exp]
            }
        }
    }

    fun save() {
        transaction {
            table.replace {
                it[id] = userId
                it[exp] = experience
            }
        }
    }

}