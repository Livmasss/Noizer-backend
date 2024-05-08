import com.livmas.noizer_backend.SpringConfiguration
import com.livmas.noizer_backend.data.entities.TrackEntity
import com.livmas.noizer_backend.data.repositories.TrackRepository
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ContextConfiguration
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
    fun testTrackRepositoryFindAllByTitleMethod() {
        val track = TrackEntity(null, "aaa", "Auth","https://isaac-items.ru/images/parts/repentance/items.png?2", "https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u")

        trackRepository.save(track)
        val founded = trackRepository.findAllByTitle(track.title)[0]

        assertEquals(track.title, founded.title)
    }

    @Test
    fun testTrackRepository() {
        val track = TrackEntity(null, "aaa", "Auth","https://isaac-items.ru/images/parts/repentance/items.png?2", "https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/%2Bchecked%2B/a/aaa.m3u")

        trackRepository.save(track)
        val firstRow = trackRepository.findAll()[0]

        assertFalse (firstRow.id == null)

        val founded = trackRepository.findById(firstRow.id!!)

        assertTrue (founded.isPresent)
        assertEquals(founded.get(), firstRow)
    }
}