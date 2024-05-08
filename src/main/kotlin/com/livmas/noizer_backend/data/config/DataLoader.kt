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
        trackRepository.save(TrackEntity(null, "Люти фоннк", "MC Chuma", "https://t2.genius.com/unsafe/504x504/https%3A%2F%2Fimages.genius.com%2Fe4833b496aab74f8f208e91bde50dbd5.1000x1000x1.png", "http://pro13.easy4.team/segments/output.m3u8"))
    }
}