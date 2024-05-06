package com.livmas.noizer_backend.presentation

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.domain.GetTrackUriByIdUseCase
import com.livmas.noizer_backend.domain.GetTracksByTitleUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class MainController @Autowired constructor(
    private val getTrackUriByIdUseCase: GetTrackUriByIdUseCase,
    private val getTracksByTitleUseCase: GetTracksByTitleUseCase
) {

    @GetMapping("/")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("/track")
    fun getTrackUrlById(@PathVariable id: UUID?): URI {
        return getTrackUriByIdUseCase.execute(UUID.fromString(""))
    }

    @GetMapping("/search")
    fun getTrackByIdTitle(@RequestParam title: String): List<TrackEntity> {
        return getTracksByTitleUseCase.execute(title)
    }
}