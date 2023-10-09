package com.sj.reactive;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;
import reactor.core.publisher.Mono;

@MicronautTest
class ReactiveproTest {

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }


    @Test
    public void test(){

        Mono.create(monoSink -> monoSink.success("welocme"));
        Mono.fromSupplier(()-> "welocme");
    }

}
