package com.livmas.noizer_backend.data.repositories

import com.livmas.noizer_backend.data.entities.TrackEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface TrackRepository: JpaRepository<TrackEntity, Long> {
    @Query("SELECT t FROM TrackEntity t WHERE t.title = :title")
    fun findAllByTitle(@Param("title") title: String): List<TrackEntity>

    @Query("SELECT t FROM TrackEntity t WHERE t.author = :author")
    fun findAllByAuthor(@Param("author") author: String): List<TrackEntity>

    @Query("SELECT t FROM TrackEntity t WHERE LOWER(t.title) LIKE %:title%")
    fun findByTitleContaining(title: String): List<TrackEntity>
}