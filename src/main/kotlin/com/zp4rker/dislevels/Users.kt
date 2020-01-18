package com.zp4rker.dislevels

import org.jetbrains.exposed.sql.Table

class Users(serverId: String) : Table("dislevels_$serverId") {
    val id = varchar("userId", 20).uniqueIndex()
    val exp = long("exp")
}