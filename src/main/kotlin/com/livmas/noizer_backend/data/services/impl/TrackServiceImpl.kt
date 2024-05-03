package com.livmas.noizer_backend.data.services.impl

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.exceptions.EntityNotFoundException
import com.livmas.noizer_backend.data.repositories.TrackRepository
import com.livmas.noizer_backend.data.services.TrackService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class TrackServiceImpl @Autowired constructor(
    val repository: TrackRepository
) : TrackService {
    override fun getTrackById(id: UUID): TrackEntity {
        val track = repository.findByIdOrNull(id) ?: throw EntityNotFoundException()

        return track
    }

    override fun createTrack(track: TrackEntity) {
        repository.save(track)
    }
}