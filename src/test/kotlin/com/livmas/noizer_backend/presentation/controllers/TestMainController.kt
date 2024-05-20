package com.livmas.noizer_backend.presentation.controllers

import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.domain.usecases.GetTracksByTitleUseCase
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest
@AutoConfigureMockMvc
class TestMainController {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var getTracksByTitleUseCase: GetTracksByTitleUseCase
    private val tracks = listOf(
        TrackEntity(null,
            "Test MVC",
            "Author",
            "",
            "")
    )

    @Test
    fun testSearchByTitleEndpoint() {
        every { getTracksByTitleUseCase.execute("Test") } returns tracks

        mockMvc.perform(get("/search?title=Test"))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }
}