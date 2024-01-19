package com.example.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class OrderStatusesForRemoval {

    List<String> allowed;
    List<String> forbidden;
}