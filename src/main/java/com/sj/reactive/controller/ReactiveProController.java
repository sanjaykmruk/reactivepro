package com.sj.reactive.controller;

import com.sj.reactive.service.UserService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/reactive")
// Not needed
@ExecuteOn(TaskExecutors.IO)
public class ReactiveProController {


    @Inject
    private UserService userService;

    @Get("/users")
    @Produces(MediaType.TEXT_EVENT_STREAM)
    public Flux<String> getUsers() {

        return userService.getUsers();
    }

    @Get("/user")
    @Produces(MediaType.TEXT_EVENT_STREAM)
    public Mono<String> getUser(){
        return userService.getUser();
    }

}
