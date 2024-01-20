package daiho.codechallenge.rapiddweller.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class WebConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        // Allow all origins, you may want to configure this based on your requirements
        config.allowedOrigins = listOf("*")

        // Allow specific headers and methods
        config.allowedHeaders = listOf("*")
        config.allowedMethods = listOf("*")

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
