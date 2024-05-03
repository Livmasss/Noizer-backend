package com.livmas.noizer_backend.data.repositories

import com.livmas.noizer_backend.data.entities.TrackEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TrackRepository: JpaRepository<TrackEntity, UUID>