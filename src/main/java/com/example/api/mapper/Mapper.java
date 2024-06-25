package com.example.api.mapper;

import com.example.api.dto.Job;
import com.example.api.dto.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    List<Job> findAll();

    List<Job> findListId(int id);

    void insertUser(User user);

    User findUserByIdAndPassword(@Param("id") String id,@Param("password")String password);


}
