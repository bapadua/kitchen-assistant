package io.github.bapadua.fooder.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class VersionController {

    @GetMapping("/version")
    public Mono<ResponseEntity<String>> getVersion() {
        return Mono.just(ResponseEntity.ok("1.0"));
    }
}
