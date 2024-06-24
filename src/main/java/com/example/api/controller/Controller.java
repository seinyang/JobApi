package com.example.api.controller;

import com.example.api.dto.Job;
import com.example.api.dto.LoginRequest;
import com.example.api.dto.User;
import com.example.api.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "list", description = "list 관련 API 입니다.")
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/jobs")
public class Controller {

    public final JobService jobService;

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
    public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {

        String id=loginRequest.getId();
        String password=loginRequest.getPassword();

        User authenticateUser= jobService.authenticateUser(id, password);
        // 인증 성공 시 사용자 정보 반환, 실패 시 UNAUTHORIZED 반환
        if (authenticateUser !=null) {
            return ResponseEntity.ok(authenticateUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
