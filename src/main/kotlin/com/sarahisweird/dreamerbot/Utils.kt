package com.sarahisweird.dreamerbot

import com.jessecorbett.diskord.api.model.Message

fun messageContainsPicture(msg: Message): Boolean = msg.attachments.any { it.imageWidth != null }