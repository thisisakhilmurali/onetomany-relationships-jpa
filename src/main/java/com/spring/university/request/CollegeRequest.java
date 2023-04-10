package com.spring.university.request;

import com.spring.university.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollegeRequest {
    private String name;
    private List<String> departments;
}
