package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.List;

class FluxAndMonoGeneratorServiceTest {

//    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

//    @Test
//    void namesFlux() {
//        //given
//
//        //when
//        var namesFlux = fluxAndMonoGeneratorService.nameFlux();
//
//        //then
//        StepVerifier.create(namesFlux)
////                .expectNext("alex", "ben", "chloe")
//                .expectNextCount(3)
//                .verifyComplete();
//    }
//
//    @Test
//    void namesMono() {
//        // given
//
//        //when
//        var namesMono = fluxAndMonoGeneratorService.nameMono();
//
//        //then
//        StepVerifier.create(namesMono)
//                .expectNext("alex")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxMap() {
//
//        // given
//
//        // when
//        var namesFluxMap = fluxAndMonoGeneratorService.nameFluxMap();
//
//        // then
//        StepVerifier.create(namesFluxMap)
//                .expectNext("ALEX", "BEN", "CHLOE")
//                .verifyComplete();
//    }
//
//    @Test
//    void filterFluxMap() {
//        // given
//
//        // when
//        var filterFluxMap = fluxAndMonoGeneratorService.filterFluxMap();
//        // then
//        StepVerifier.create(filterFluxMap)
//                .expectNext("ben", "chloe")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxFlatMapAsync() {
//        // given
//
//        // when
//        var namesFluxFlatMapAsync = fluxAndMonoGeneratorService.nameFluxFlatMapAsync();
//
//        // then
//        StepVerifier.create(namesFluxFlatMapAsync)
//                .expectNextCount(12)
////                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxConcatMapAsync() {
//        var namesFluxFlatMapAsync = fluxAndMonoGeneratorService.nameFluxConcatMapAsync();
//
//        // then
//        StepVerifier.create(namesFluxFlatMapAsync)
//                .expectNextCount(12)
////                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameMonoFlatMap() {
//        var namesFluxFlatMapAsync = fluxAndMonoGeneratorService.nameMonoFlatMap();
//
//        // then
//        StepVerifier.create(namesFluxFlatMapAsync)
//                .expectNext(List.of("A", "L", "E", "X"))
////                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameMonoFlatMapMany() {
//        var source = fluxAndMonoGeneratorService.nameMonoFlatMapMany();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "L", "E", "X")
////                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxTransform() {
//        var source = fluxAndMonoGeneratorService.nameFluxTransform();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxTransform2() {
//        var source = fluxAndMonoGeneratorService.nameFluxTransform2();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void nameFluxTransformSwitchIfEmpty() {
//        var source = fluxAndMonoGeneratorService.nameFluxTransform2();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "L", "E", "X", "B", "E", "N", "C", "H", "L", "O", "E")
//                .verifyComplete();
//    }
//
//    @Test
//    void testNameFluxTransformSwitchIfEmpty() {
//        var source = fluxAndMonoGeneratorService.nameFluxTransformSwitchIfEmpty();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("D", "E", "F", "A", "U", "L", "T")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreConcat() {
//        var source = fluxAndMonoGeneratorService.exploreConcat();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "B", "C", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreConcatWith() {
//        var source = fluxAndMonoGeneratorService.exploreConcatWith();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "B", "C", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreMonoConcatWith() {
//        var source = fluxAndMonoGeneratorService.exploreMonoConcatWith();
//
//        // then
//        StepVerifier.create(source)
//                .expectNext("A", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreMerge() {
//        var source = fluxAndMonoGeneratorService.exploreMerge();
//
//        // then
//        StepVerifier.create(source)
//                .expectNextCount(6)
////                .expectNext("A", "B", "C", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreMergeWith() {
//        var source = fluxAndMonoGeneratorService.exploreMergeWith();
//
//        // then
//        StepVerifier.create(source)
//                .expectNextCount(6)
////                .expectNext("A", "B", "C", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreMergeSequential() {
//        var source = fluxAndMonoGeneratorService.exploreMergeSequential();
//
//        // then
//        StepVerifier.create(source)
////                .expectNextCount(6)
//                .expectNext("A", "B", "C", "D", "E", "F")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreZip() {
//        var source = fluxAndMonoGeneratorService.exploreZip();
//
//        // then
//        StepVerifier.create(source)
////                .expectNextCount(6)
//                .expectNext("AD", "BE", "CF")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreZipWith() {
//        var source = fluxAndMonoGeneratorService.exploreZipWith();
//
//        // then
//        StepVerifier.create(source)
////                .expectNextCount(6)
//                .expectNext("AD", "BE", "CF")
//                .verifyComplete();
//    }
//
//    @Test
//    void exploreZip01() {
//        var source = fluxAndMonoGeneratorService.exploreZip01();
//
//        // then
//        StepVerifier.create(source)
////                .expectNextCount(6)
//                .expectNext("AD14", "BE25", "CF36")
//                .verifyComplete();
//    }
}
