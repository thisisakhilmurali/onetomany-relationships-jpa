package com.spring.university.controller;


import com.spring.university.entity.College;
import com.spring.university.entity.Department;
import com.spring.university.repository.CollegeRepository;
import com.spring.university.repository.DepartmentRepository;
import com.spring.university.request.CollegeRequest;
import com.spring.university.response.CollegeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/employees")
    public ResponseEntity<College> saveDetails(@RequestBody CollegeRequest collegeRequest) {

        College college = new College(collegeRequest);
        college = collegeRepository.save(college);

        for (String s: collegeRequest.getDepartments()) {
            Department d = new Department();
            d.setName(s);
            d.setCollege(college);

            departmentRepository.save(d);
        }

        return new ResponseEntity<College>(
                college,
                HttpStatus.CREATED
        );

    }

    @GetMapping("/employees")
    public ResponseEntity<List<CollegeResponse>> getDetails() {

        List<College> list = collegeRepository.findAll();
        List<CollegeResponse> responseList = new ArrayList<>();

        list.forEach(e -> {
            CollegeResponse collegeResponse = new CollegeResponse();
            collegeResponse.setId(e.getId());
            collegeResponse.setName((e.getName()));

            List<String> depts = new ArrayList<>();
            for(Department d : e.getDepartments()) {
                depts.add(d.getName());
            }

            collegeResponse.setDepartments(depts);
            responseList.add(collegeResponse);
        });

        return new ResponseEntity<List<CollegeResponse>>(responseList, HttpStatus.OK);
    }

}
