package com.livmas.noizer_backend.data.config

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.repositories.TrackRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DataLoader @Autowired constructor(
    trackRepository: TrackRepository
) {
    init {
        trackRepository.save(TrackEntity(null, "aaa", "MC Chuma", "https://isaac-items.ru/images/parts/repentance/items.png?2", "https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u"))
    }
}