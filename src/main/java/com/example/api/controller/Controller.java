package com.example.api.controller;

import com.example.api.dto.JwtResponse;
import com.example.api.dto.Job;
import com.example.api.dto.LoginRequest;
import com.example.api.dto.User;
import com.example.api.jwt.JwtUtil;
import com.example.api.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Tag(name = "list", description = "list 관련 API 입니다.")
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class Controller {

    public final JobService jobService;
    public final JwtUtil jwtUtil;

    @Operation(
            summary = "list",
            description = "list 데이터를 뿌립니다."
    )


    @GetMapping("/listAll")
    public List<Job> getJobList(){

        return jobService.getJobList();
    }


    @Operation(
            summary = "list",
            description = "list 아이디 찾아오기"
    )


    @GetMapping("/listId")
    public List<Job> getJobListById(@RequestParam("id") int id) {
        return jobService.getJobListId(id);
    }



    @Operation(
            summary = "login",
            description = "사용자 로그인 인증"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {

        String id=loginRequest.getId();
        String password=loginRequest.getPassword();

        User authenticateUser= jobService.authenticateUser(id, password);
        // 인증 성공 시 사용자 정보 반환, 실패 시 UNAUTHORIZED 반환
        if (authenticateUser !=null) {
            String token = jwtUtil.generateToken(authenticateUser.getId());

            // JWT 토큰을 쿠키에 담아서 클라이언트에게 전달
            Cookie cookie = new Cookie("jwtToken", token);
            cookie.setMaxAge((int) jwtUtil.getTokenValidityInSeconds()); // 쿠키 유효 기간 설정
            cookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
            cookie.setHttpOnly(true); // JavaScript로 접근할 수 없도록 설정
            response.addCookie(cookie);

            return ResponseEntity.ok(new JwtResponse(token, authenticateUser));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@CookieValue("jwtToken") String token) {
        if (jwtUtil.validateToken(token)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}
