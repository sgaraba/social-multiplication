package microservices.book.multiplication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@Slf4j
@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;
    @Value("${server.port}")
    private int serverPort;

    @PostMapping
    ResponseEntity<MultiplicationResultAttempt> postResult(@RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
        return ResponseEntity.ok(multiplicationService.checkAttempt(multiplicationResultAttempt));
    }

    @GetMapping
    ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(
                multiplicationService.getStatsForUser(alias)
        );
    }

    @GetMapping("/{resultId}")
    ResponseEntity<MultiplicationResultAttempt> getResultById(final @PathVariable("resultId") Long resultId) {
        log.info("Retrieving result {} from server @ {}", resultId, serverPort);
        return ResponseEntity.ok(multiplicationService.getResultById(resultId));
    }
}
