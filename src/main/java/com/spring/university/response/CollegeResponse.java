package com.spring.university.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeResponse {
    private Long id;
    private String name;
    private List<String> departments;
}
