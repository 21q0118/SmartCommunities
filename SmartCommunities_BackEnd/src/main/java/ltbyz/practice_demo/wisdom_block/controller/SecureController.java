package ltbyz.practice_demo.wisdom_block.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class SecureController {
    /**
     * 查询 用户信息，登录后携带JWT才能访问
     */
    @PostMapping("/secure/refresh")
    public String login(HttpServletRequest request) {
        System.out.println("6666");
        return "999";
        // return "?";
    }
}
