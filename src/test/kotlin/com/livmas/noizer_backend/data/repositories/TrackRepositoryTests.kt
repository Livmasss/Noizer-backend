package com.livmas.noizer_backend.data.repositories

import com.livmas.noizer_backend.SpringConfiguration
import com.livmas.noizer_backend.data.entities.TrackEntity
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ContextConfiguration(classes = [SpringConfiguration::class])
@DataJpaTest
class TrackRepositoryTests {
    @Autowired
    final lateinit var trackRepository: TrackRepository

    private final val track = TrackEntity(
        null,
        "Test Track",
        "Author",
        "https://isaac-items.ru/images/parts/repentance/items.png?2",
        "https://raw.githubusercontent.com/junguler/m3u-radio-music-playlists/main/2Bchecked2B/a/aaa.m3u"
    )

    @Test
    fun testTrackRepositoryFindAllByTitleMethod() {
        trackRepository.save(track)
        val founded = trackRepository.findAllByTitle(track.title)[0]

        assertEquals(track.title, founded.title)
    }

    @Test
    fun testTrackRepository() {
        trackRepository.save(track)
        val firstRow = trackRepository.findAll()[0]

        assertFalse (firstRow.id == null)

        val founded = trackRepository.findById(firstRow.id!!)

        assertTrue (founded.isPresent)
        assertEquals(founded.get(), firstRow)
    }

    @Test
    fun testSearchTrackByFullTitle() {
        trackRepository.save(track)

        val foundedTrack = trackRepository.findByTitleContaining(track.title.lowercase())[0]
        assertEquals(track, foundedTrack)
    }

    @Test
    fun testSearchTrackByStartTitle() {
        trackRepository.save(track)

        val foundedTracks = trackRepository.findByTitleContaining(track.title.substring(0..3).lowercase())
        assertTrue(foundedTracks.any{
            it.title == track.title
        })
    }

    @Test
    fun testSearchTrackByMiddleTitle() {
        trackRepository.save(track)

        val foundedTracks = trackRepository.findByTitleContaining(track.title.substring(2..5).lowercase())
        assertTrue(foundedTracks.any{
            it.title == track.title
        })
    }

    @Test
    fun testSearchTrackByEndTitle() {
        trackRepository.save(track)

        val foundedTracks = trackRepository.findByTitleContaining(track.title.substring(4 until track.title.length).lowercase())
        assertTrue(foundedTracks.any{
            it.title == track.title
        })
    }
}