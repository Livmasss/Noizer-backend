package com.livmas.noizer_backend.domain

import com.livmas.noizer_backend.data.services.TrackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.URI
import java.util.*

@Component
class GetTrackUriByIdUseCase @Autowired constructor(
    val trackService: TrackService

)  {
    fun execute(id: UUID): URI {
        return URI.create(trackService.getTrackById(id).trackUri)
    }
}