package com.livmas.noizer_backend.presentation

import com.livmas.noizer_backend.domain.GetTrackUriByIdUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID


@RestController
class MainController @Autowired constructor(
    private val getTrackUriByIdUseCase: GetTrackUriByIdUseCase
) {

    @GetMapping("/")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("/track")
    fun getTrackUrlById(@PathVariable id: UUID?): URI {
        return getTrackUriByIdUseCase.execute(UUID.fromString("1"))
    }
}