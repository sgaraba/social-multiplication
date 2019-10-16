package microservices.book.gamification.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.gamification.service.AdminService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("test")
@RestController
@RequestMapping("/gamification/admin")
@RequiredArgsConstructor
class AdminController {
    private final AdminService adminService;

    @PostMapping("/delete-db")
    public ResponseEntity deleteDatabase() {
        adminService.deleteDatabaseContents();
        return ResponseEntity.ok().build();
    }
}