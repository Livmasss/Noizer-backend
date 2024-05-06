package com.livmas.noizer_backend

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories("com.livmas.noizer_backend.data.repositories")
@EntityScan("com.livmas.noizer_backend.data.entities")
class SpringConfiguration {

}
