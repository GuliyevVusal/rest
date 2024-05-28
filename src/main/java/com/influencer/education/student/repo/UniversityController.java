package com.influencer.education.student.repo;

import com.influencer.education.student.entity.University;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {


    private final UniversityRepoData dataRepo;


    public UniversityController(UniversityRepoData dataRepo) {
        this.dataRepo = dataRepo;
    }

    @GetMapping
    public List<University> getList() {
        return dataRepo.findAll();

    }
}
