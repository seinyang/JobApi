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

        return mapper.findUserByIdAndPassword(id,password);
    }
}
