package com.sj.reactive.service;


import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
public class UserService {

    @Inject
    RepositoryService repositoryService;


    public Flux<String> getUsers() {

        return repositoryService.getUsers();


    }

    public Mono<String> getUser() {
        return repositoryService.getUser();
    }
}
