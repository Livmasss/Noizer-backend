package com.livmas.noizer_backend.data.services

import com.livmas.noizer_backend.data.entities.TrackEntity
import java.util.*

interface TrackService {
    fun getTrackById(id: UUID): TrackEntity
    fun createTrack(track: TrackEntity)
    fun getTrackByTitle(title: String): List<TrackEntity>
}