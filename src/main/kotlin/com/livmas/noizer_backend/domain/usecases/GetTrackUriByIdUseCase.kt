package com.livmas.noizer_backend.domain.usecases

import com.livmas.noizer_backend.data.services.TrackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.URI

@Component
class GetTrackUriByIdUseCase @Autowired constructor(
    val trackService: TrackService

)  {
    fun execute(id: Long): URI {
        val trackUrl = trackService.getTrackById(id).trackUri
        return URI.create(trackUrl)
    }
}