import com.livmas.noizer_backend.SpringConfiguration
import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.repositories.TrackRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ContextConfiguration
import java.net.URI
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ContextConfiguration(classes = [SpringConfiguration::class])
@DataJpaTest
class HibernateTest {

    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var trackRepository: TrackRepository

    @Test
    fun testTrackRepository() {
        val track = TrackEntity(null, "aaa", "Auth","https://isaac-items.ru/images/parts/repentance/items.png?2", "https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u")

        trackRepository.save(track)
        val founded = trackRepository.findAllByTitle(track.title)[0]

        assertEquals(track.title, founded.title)
    }
}