package microservices.book.gamification.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.gamification.domain.GameStats;
import microservices.book.gamification.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class implements a REST API for the Gamification User Statistics service.
 */
@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
class UserStatsController {

    private final GameService gameService;

    @GetMapping
    public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
        return gameService.retrieveStatsForUser(userId);
    }
}