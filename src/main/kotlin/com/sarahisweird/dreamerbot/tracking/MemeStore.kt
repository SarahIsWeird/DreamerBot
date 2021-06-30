package com.sarahisweird.dreamerbot.tracking

import java.time.Instant

class MemeStore {
    companion object {
        private val trackedMemes: MutableList<TrackedMeme> = mutableListOf()

        fun track(messageId: String) {
            if (trackedMemes.find { it.id == messageId } != null) return

            trackedMemes.add(TrackedMeme(messageId, Instant.now()))
        }

        fun promote(messageId: String, archiveId: String) {
            trackedMemes.find { it.id == messageId }?.promote(archiveId)
        }
    }
}