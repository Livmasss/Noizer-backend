package com.livmas.noizer_backend.data.entities

import jakarta.persistence.*
import java.net.URI
import java.util.UUID

@Entity
@Table(name = "tracks")
data class TrackEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,

    val trackUri: URI
)