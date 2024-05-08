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
        trackRepository.save(TrackEntity(null, "Лютый фонк", "MC Chuma", "https://t2.genius.com/unsafe/504x504/https%3A%2F%2Fimages.genius.com%2Fe4833b496aab74f8f208e91bde50dbd5.1000x1000x1.png", "http://pro13.easy4.team/segments/output.m3u8"))
        trackRepository.save(TrackEntity(null, "Царица", "ANNA ASTI", "https://t2.genius.com/unsafe/504x504/https%3A%2F%2Fimages.genius.com%2F151d8f514655fbc49960bc43c377bc6e.1000x1000x1.png", "http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8"))
        trackRepository.save(TrackEntity(null, "Стужа", "Пятерка", "https://t2.genius.com/unsafe/504x504/https%3A%2F%2Fimages.genius.com%2F71ab5e17e28907ba5298720dc8f9c985.1000x1000x1.png", "http://pro13.easy4.team/segments/output.m3u8"))
        trackRepository.save(TrackEntity(null, "LIPSI HA", "Instasamka", "https://t2.genius.com/unsafe/504x504/https%3A%2F%2Fimages.genius.com%2F0fcdc3a7595c08c0a3931f12ac2165ec.873x873x1.jpg", "http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8"))
    }
}