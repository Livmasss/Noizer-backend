package com.livmas.noizer_backend.data.services

import com.livmas.noizer_backend.data.entities.TrackEntity

interface TrackService {
    fun getTrackById(id: Long): TrackEntity
    fun createTrack(track: TrackEntity)
    fun getTrackByTitle(title: String): List<TrackEntity>
    fun findTracksByTitle(title: String): List<TrackEntity>
    fun getFirstTracks(count: Int): List<TrackEntity>
}