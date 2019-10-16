package microservices.book.gamification.service;

import lombok.RequiredArgsConstructor;
import microservices.book.gamification.repository.BadgeCardRepository;
import microservices.book.gamification.repository.ScoreCardRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Profile("test")
@Service
@RequiredArgsConstructor
class AdminServiceImpl implements AdminService {

    private final BadgeCardRepository badgeCardRepository;
    private final ScoreCardRepository scoreCardRepository;

    @Override
    public void deleteDatabaseContents() {
        scoreCardRepository.deleteAll();
        badgeCardRepository.deleteAll();
    }
}
