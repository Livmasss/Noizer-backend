package com.livmas.noizer_backend.data

import com.livmas.noizer_backend.data.entities.TrackEntity
import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.service.ServiceRegistry
import java.util.*

class HibernateSessionFactoryUtil {

    companion object {
        private var sessionFactory: SessionFactory? = null

        fun buildSessionFactory(): SessionFactory {

            try {
                val configuration = Configuration()

                initiateProperties(configuration)
                initiateTables(configuration)

                val serviceRegistry: ServiceRegistry =
                    StandardServiceRegistryBuilder().applySettings(configuration.properties).build()
//                HibernateSessionFactoryUtil.logger.info("Hibernate Java Config serviceRegistry created")
                return configuration.buildSessionFactory(serviceRegistry)
            } catch (ex: Exception) {
//                HibernateSessionFactoryUtil.logger.error("Initial SessionFactory creation failed.%s".formatted(ex))
                throw ExceptionInInitializerError(ex)
            }
        }


        fun getSessionFactory(): SessionFactory {
            if (sessionFactory == null)
                sessionFactory = buildSessionFactory()
            return sessionFactory!!
        }

        private fun initiateProperties(configuration: Configuration) {
            //Create Properties, can be read from property files too
            val props = Properties()
            props.load(Thread.currentThread().contextClassLoader.getResourceAsStream("hibernate-dev.properties"))

            configuration.setProperties(props)
        }


        private fun initiateTables(configuration: Configuration) {
            //Player properties
            configuration.addAnnotatedClass(TrackEntity::class.java)
        }
    }
}
