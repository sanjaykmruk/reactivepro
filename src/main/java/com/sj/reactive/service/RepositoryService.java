package com.sj.reactive.service;

import jakarta.inject.Singleton;
import net.datafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Locale;

@Singleton
public class RepositoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryService.class);

    Faker faker = new Faker();

    public Flux<String> getUsers() {

        Flux<String> flux = Flux.range(1, 10)
                .map(i ->
                {
//                    sleepMillis(1000);
                    String name = faker.name().fullName();
                    LOGGER.info("Generating name : {}", name );
                    return name;
                });
        return flux
                .delayElements(Duration.of(1000, ChronoUnit.MILLIS))
                .map(s -> s.toUpperCase(Locale.ENGLISH));
//                .collect(Collectors.toList()).block(Duration.ofMillis(100));
    }

    public Mono<String> getUser() {
        Mono<String> mono = Mono.fromSupplier(()-> faker.name().fullName().toUpperCase());
        return mono
                .delayElement(Duration.of(5000, ChronoUnit.MILLIS))
                .map(String::toUpperCase);
    }

    private static void sleepMillis(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
