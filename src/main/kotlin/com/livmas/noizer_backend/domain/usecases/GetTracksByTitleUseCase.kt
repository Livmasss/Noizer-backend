package com.livmas.noizer_backend.domain.usecases

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.services.TrackService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetTracksByTitleUseCase @Autowired constructor(
    val trackService: TrackService

)  {
    fun execute(title: String): List<TrackEntity> {
        val tracks = trackService.getTrackByTitle(title)
        if (tracks.isEmpty())
            return tracks
        LoggerFactory.getLogger(GetTracksByTitleUseCase::class.java).info("Tracks founded: ${tracks.size}. First track: ${tracks[0].title}")
        return tracks
    }
}