package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoGeneratorService {

    public Flux<String> nameFlux() {
        // db or a remote service call in the real world project
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .log();
    }

    public Mono<String> nameMono() {
        return Mono.just("alex")
                .log();
    }

    public Flux<String> nameFluxMap() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                .log();
    }

    public Flux<String> nameFluxFlatMap() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                .flatMap(this::splitStringFlux)
                .log();
    }

    public Flux<String> nameFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                .flatMap(this::splitStringFluxWithDelay)
                .log();
    }

    public Flux<String> nameFluxConcatMapAsync() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                .concatMap(this::splitStringFluxWithDelay)
                .log();
    }

    public Flux<String> splitStringFlux(String name) {
        var charArray = name.split("");
        return Flux.fromArray(charArray);
    }

    public Flux<String> splitStringFluxWithDelay(String name) {
        var charArray = name.split("");
//        var randomDelay = new Random().nextInt(1000);
        var randomDelay = 1000;
        return Flux.fromArray(charArray)
                .delayElements(Duration.ofMillis(randomDelay));
    }

    public Flux<String> filterFluxMap() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .filter(name -> !name.equals("alex"))
                .log();
    }

    public Mono<String> nameMonoMap() {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .log();
    }

    public Mono<List<String>> nameMonoFlatMap() {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .flatMap(this::splitStringMono)
                .log();
    }

    public Flux<String> nameMonoFlatMapMany() {
        return Mono.just("alex")
                .map(String::toUpperCase)
                .flatMapMany(this::splitStringFluxWithDelay)
                .log();
    }

    private Mono<List<String>> splitStringMono(String s) {
     var charArray = s.split("");
     var resultList = List.of(charArray);
     var randomDelay = 1000;
     return Mono.just(resultList);
    }

    private List<String> splitString(String s) {
        var charArray = s.split("");
        return List.of(charArray);
    }

    public Flux<String> nameFluxTransform() {
        Function<Flux<String>, Flux<String>> result = name -> name.map(String::toUpperCase);

        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .transform(result)
                .flatMap(this::splitStringFlux)
                .log();
    }

    public Flux<String> nameFluxTransform2() {
        Function<Flux<String>, Flux<String>> result = name -> name.map(String::toUpperCase).filter(s -> s.length() > 6);

        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .transform(result)
                .flatMap(this::splitStringFlux)
                .defaultIfEmpty("default")
                .log();
    }

    public Flux<String> nameFluxTransformSwitchIfEmpty() {
        Function<Flux<String>, Flux<String>> result = name ->
                name.map(String::toUpperCase)
                .filter(s -> s.length() > 6)
                .flatMap(this::splitStringFlux);

        var defaultFlux = Flux.just("default")
                .transform(result);

        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .transform(result)
                .switchIfEmpty(defaultFlux)
                .log();
    }

    public Flux<String> exploreConcat() {
        var abcFlux = Flux.just("A", "B", "C");
        var defFlux = Flux.just("D", "E", "F");

        return Flux.concat(abcFlux, defFlux)
                .log();
    }

    public Flux<String> exploreConcatWith() {
        var abcFlux = Flux.just("A", "B", "C");
        var defFlux = Flux.just("D", "E", "F");

        return abcFlux.concatWith(defFlux)
                .log();
    }

    public Flux<String> exploreMonoConcatWith() {
        var abcFlux = Mono.just("A");
        var defFlux = Flux.just("D", "E", "F");

//        return abcFlux.concatWith(defFlux)
//                .log();

        return Flux.concat(abcFlux, defFlux).log();
    }

    public Flux<String> exploreMerge() {
        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return Flux.merge(abcFlux, defFlux)
                .log();

    }

    public Flux<String> exploreMergeWith() {
        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return abcFlux.mergeWith(defFlux)
                .log();

    }

    public Flux<String> exploreMergeSequential() {
        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return Flux.mergeSequential(abcFlux, defFlux)
                .log();
    }

    public Flux<String> exploreZip() {
        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return Flux.zip(abcFlux, defFlux, (first, second) -> first + second)
                .log();
    }

    public Flux<String> exploreZipWith() {
        var abcFlux = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        var defFlux = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(125));

        return abcFlux.zipWith(defFlux, (first, second) -> first + second)
                .log();
    }

    public Flux<String> exploreZip01() {
        var abcFlux = Flux.just("A", "B", "C");
        var defFlux = Flux.just("D", "E", "F");
        var flux3 = Flux.just("1", "2", "3");
        var flux4 = Flux.just("4", "5", "6");

        return Flux.zip(abcFlux, defFlux, flux3, flux4)
                .map(t -> t.getT1() + t.getT2() + t.getT3() + t.getT4())
                .log();
    }




    public static void main(String[] args) {
        var fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

//        fluxAndMonoGeneratorService.nameFlux().subscribe(name -> System.out.println("flux name is: " + name));
//
//        fluxAndMonoGeneratorService.nameMono().subscribe(name -> System.out.println("mono name is: " + name));

//        fluxAndMonoGeneratorService.namesFluxMap().subscribe(name -> System.out.println(name));

        fluxAndMonoGeneratorService.nameFluxFlatMap().subscribe(System.out::println);
    }
}
