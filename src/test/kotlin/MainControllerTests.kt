import com.livmas.noizer_backend.SpringConfiguration
import com.livmas.noizer_backend.domain.GetTrackUriByIdUseCase
import com.livmas.noizer_backend.presentation.MainController
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.net.URI
import java.util.*


@WebMvcTest(MainController::class)
@ContextConfiguration(classes = [SpringConfiguration::class])
class MainControllerTests @Autowired constructor(
    val mockMvc: MockMvc
) {
    @MockkBean
    lateinit var getTrackUriByIdUseCase: GetTrackUriByIdUseCase

    @Test
    fun testMainController() {
        every { getTrackUriByIdUseCase.execute(UUID.randomUUID()) } returns URI.create("https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u")

        mockMvc.perform(MockMvcRequestBuilders.get("/track"))
            .andExpect(MockMvcResultMatchers.status().isOk)
    }
}