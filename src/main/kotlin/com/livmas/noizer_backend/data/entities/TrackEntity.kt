package com.livmas.noizer_backend.data.entities

import jakarta.persistence.*

@Entity
@Table(name = "tracks")
data class TrackEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @Column
    var title: String,
    @Column
    var author: String,

    @Column(name = "cover_uri")
    var coverUri: String,
    @Column(name = "track_uri")
    var trackUri: String
)