package com.example.api.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Job {

    public int id;
    public String content;
    private Date time;    // time 필드를 java.util.Date 타입으로 변경
    private boolean result;   // result 필드를 boolean 타입으로 변

}
