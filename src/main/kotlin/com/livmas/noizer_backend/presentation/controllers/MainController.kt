package com.livmas.noizer_backend.presentation.controllers

import com.livmas.noizer_backend.domain.usecases.GetTrackUriByIdUseCase
import com.livmas.noizer_backend.domain.usecases.GetTracksByTitleUseCase
import com.livmas.noizer_backend.domain.usecases.GetTracksFeedUseCase
import com.livmas.noizer_backend.presentation.models.TracksResponseModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.*

@RestController
class MainController @Autowired constructor(
    private val getTrackUriByIdUseCase: GetTrackUriByIdUseCase,
    private val getTracksByTitleUseCase: GetTracksByTitleUseCase,
    private val getTracksFeedUseCase: GetTracksFeedUseCase
) {

    @GetMapping("/")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("/track")
    fun getTrackUrlById(@RequestParam id: Long): URI {
        return getTrackUriByIdUseCase.execute(id)
    }

    @GetMapping("/search")
    fun getTrackByIdTitle(@RequestParam title: String): TracksResponseModel {
        return TracksResponseModel(
            getTracksByTitleUseCase.execute(title)
        )
    }

    @GetMapping("/feed")
    fun getTracksFeed(): TracksResponseModel {
        return TracksResponseModel(
            getTracksFeedUseCase.execute()
        )
    }
}