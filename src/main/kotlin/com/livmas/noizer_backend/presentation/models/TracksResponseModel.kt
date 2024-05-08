package com.livmas.noizer_backend.presentation.models

import com.livmas.noizer_backend.data.entities.TrackEntity

data class TracksResponseModel (
    val items: List<TrackEntity>
)