package com.livmas.noizer_backend.domain

import org.springframework.stereotype.Component
import java.net.URI
import java.util.UUID

@Component
class GetTrackUriByIdUseCase {

    fun execute(id: UUID): URI {
        return URI.create("https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u")
    }
}