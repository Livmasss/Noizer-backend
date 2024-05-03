package noizer_backend

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringApplication

fun main(args: Array<String>) {
    runApplication<SpringApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}