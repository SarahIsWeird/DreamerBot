package com.sarahisweird.dreamerbot

import com.jessecorbett.diskord.dsl.bot
import com.sarahisweird.dreamerbot.tracking.MemeStore
import kotlin.system.exitProcess

const val OWNER_ID = "116927399760756742"

suspend fun main() {
    val botToken = System.getenv("DREAMERBOT_TOKEN")

    if (botToken == null) {
        println("Please set the DREAMERBOT_TOKEN environment variable.")
        exitProcess(1)
    }

    bot(botToken) {
        messageCreated { msg ->
            if (msg.equals("#quit") && msg.author.id == OWNER_ID) {
                this.shutdown()
                return@messageCreated
            }

            if (!messageContainsPicture(msg)) return@messageCreated

            MemeStore.track(msg.id)
            println("msg tracked")
        }
    }
}