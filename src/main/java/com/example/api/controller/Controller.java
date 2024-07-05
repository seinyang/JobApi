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

@Tag(name = "리스트", description = "리스트 관련 API 입니다.")
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
            summary = "validateToken",
            description = "JWT 토큰 검증"
    )
    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@CookieValue("jwtToken") String token) {
        if (jwtUtil.validateToken(token)) {
            return ResponseEntity.ok("Token is valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
    }
}
