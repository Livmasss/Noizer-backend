package com.livmas.noizer_backend.domain

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.services.TrackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GetTracksByTitleUseCase @Autowired constructor(
    val trackService: TrackService

)  {
    fun execute(title: String): List<TrackEntity> {
        return trackService.getTrackByTitle(title)
    }
}