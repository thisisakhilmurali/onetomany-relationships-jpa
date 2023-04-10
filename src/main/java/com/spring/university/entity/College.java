package com.spring.university.entity;


import com.spring.university.request.CollegeRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "college_table")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // OneToMany Mapping
    @OneToMany(mappedBy = "college")
    private List<Department> departments;

    // Request Constructor
    public College(CollegeRequest collegeRequest) {
        this.name = collegeRequest.getName();
    }

}
