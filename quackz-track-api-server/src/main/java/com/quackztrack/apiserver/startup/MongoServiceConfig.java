package com.quackztrack.apiserver.startup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.quackztrack.apiserver.services.MongoItemsService;
import com.quackztrack.apiserver.services.base.IItemsService;

@Configuration
@Profile("Mongo")
public class MongoServiceConfig {

    @Bean
    @Scope("singleton")
    public IItemsService itemsService() {
        return new MongoItemsService();
    }
}
