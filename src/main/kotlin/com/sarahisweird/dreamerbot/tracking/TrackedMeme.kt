package com.sarahisweird.dreamerbot.tracking

import java.time.Instant

data class TrackedMeme(val id: String, val createdAt: Instant, var archivedId: String? = null, var state: Int = 0) {
    fun promote(archivedId: String) {
        this.archivedId = archivedId
        this.state = 1
    }
}
