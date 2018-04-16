package com.louikwon.example.java8.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String name;
    private Integer price;
    private Integer year;
}