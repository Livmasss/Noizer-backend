package com.livmas.noizer_backend.domain.usecases

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.services.TrackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetTracksFeedUseCase @Autowired constructor(
    private val trackService: TrackService
) {
    fun execute(): List<TrackEntity> =
        trackService.getFirstTracks(5)
}
