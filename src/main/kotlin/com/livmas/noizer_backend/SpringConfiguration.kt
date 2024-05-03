package com.livmas.noizer_backend

import com.livmas.noizer_backend.data.HibernateSessionFactoryUtil
import org.hibernate.SessionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories("com.livmas.noizer_backend.data.repositories")
class SpringConfiguration {

    @Bean(name = ["entityManagerFactory"])
    fun sessionFactory(): SessionFactory {
        return HibernateSessionFactoryUtil.getSessionFactory()
    }
}