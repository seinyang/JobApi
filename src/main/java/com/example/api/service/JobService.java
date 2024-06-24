package com.example.api.service;

import com.example.api.dto.Job;
import com.example.api.dto.User;
import com.example.api.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JobService {
    private final List<Job> jobs;
    public final Mapper mapper;

    public List<Job> getJobList(){
        return mapper.findAll();
    }
    public List<Job> getJobListId(int id){
        return mapper.findListId(id);
    }

    public void addUser(User user) {
        mapper.insertUser(user);
    }

    public User authenticateUser(String id, String password) {
        User user = mapper.findUserById(id);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return user;  // 인증 성공 시 사용자 정보 반환
        }

        return null;  // 인증 실패 시 null 반환
    }
}
