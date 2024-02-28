package com.ayalait.terminal;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CachingConfig {
 
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("estadoTerminal","estadoVentas","configuraciones","billetes","tipoArqueo","turnos","tipoCuadre",
        "estadoVentasDevueltos","formasCobros");
    }
    
    
}