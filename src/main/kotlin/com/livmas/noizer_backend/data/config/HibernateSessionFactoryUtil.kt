package com.livmas.noizer_backend.data.config

import com.livmas.noizer_backend.data.entities.TrackEntity
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.slf4j.LoggerFactory
import java.util.*

class HibernateSessionFactoryUtil {

    companion object {
        private var sessionFactory: SessionFactory? = null
        private val logger = LoggerFactory.getLogger(HibernateSessionFactoryUtil::class.java)

        fun getSessionFactory(): SessionFactory {
            if (sessionFactory == null)
                sessionFactory = buildSessionFactory()
            return sessionFactory!!
        }

        private fun buildSessionFactory(): SessionFactory {
            try {
                val hibConfig = Configuration()

                initiateProperties(hibConfig)
                initiateTables(hibConfig)

                val serviceRegistry = StandardServiceRegistryBuilder()
                    .applySettings(hibConfig.properties).build()
                logger.info("Hibernate ServiceRegistry created")

                return hibConfig.buildSessionFactory(serviceRegistry)
            } catch (ex: Exception) {
                logger.error("Initial SessionFactory creation failed: $ex")
                throw ExceptionInInitializerError(ex)
            }
        }

        private fun initiateProperties(configuration: Configuration) {
            //Create Properties, can be read from property files too
            val hibProps = Properties()
            hibProps.load(
                Thread.currentThread().contextClassLoader
                    .getResourceAsStream("hibernate-dev.properties")
            )

            configuration.setProperties(hibProps)
        }


        private fun initiateTables(configuration: Configuration) {
            //Player properties
            configuration.addAnnotatedClass(
                TrackEntity::class.java)
        }
    }
}
