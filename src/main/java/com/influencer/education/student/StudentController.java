package com.influencer.education.student;

import com.influencer.education.common.dto.CommonDTO;
import com.influencer.education.student.dto.StudentDTO;
import com.influencer.education.student.dto.StudentMapper;
import com.influencer.education.student.dto.UniversityDTO;
import com.influencer.education.student.entity.StudentEntity;
import com.influencer.education.student.entity.University;
import com.influencer.education.student.repo.StudentRepoData;
import com.influencer.education.student.repo.CustomStudentRepo;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepoData dataRepo;
    private final CustomStudentRepo customRepo;


    public StudentController(StudentRepoData dataRepo, CustomStudentRepo customRepo) {
        this.dataRepo = dataRepo;
        this.customRepo = customRepo;
    }

    @GetMapping
    public CommonDTO getList(@RequestParam(required = false) String name,
                             @RequestParam(required = false) String surname,
                             @RequestParam(required = false) String email,
                             @RequestParam(required = false, name = "university_id") Integer universityId,
                             @RequestParam(required = false) Integer age) {
        return new CommonDTO()
                .setObj(customRepo.getList(name, surname, email, universityId, age)
                            .stream()
                            .map(StudentMapper.MAPPER::toDto)
                            .collect(Collectors.toList()))
                .setDatetime(LocalDateTime.now());
    }

    @PostMapping
    public CommonDTO insert(@RequestBody StudentDTO studentDto) {
        dataRepo.save(StudentMapper.MAPPER.toEntity(studentDto));
        return new CommonDTO()
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully inserted");
    }

    @PutMapping
    public CommonDTO update(@RequestBody StudentDTO studentDto) {
        dataRepo.save(StudentMapper.MAPPER.toEntity(studentDto));
        return new CommonDTO()
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully updated");
    }


    @DeleteMapping
    public CommonDTO delete(@RequestParam Integer id) {
        dataRepo.deleteById(id);
        return new CommonDTO()
                .setDatetime(LocalDateTime.now())
                .setMessage("successfully deleted");
    }

    @GetMapping("{id}")
    public CommonDTO findById(@PathVariable("id") Integer id) {
        return new CommonDTO().setObj(
                dataRepo.findById(id).map(StudentMapper.MAPPER::toDto).orElse(new StudentDTO())
        )
                .setDatetime(LocalDateTime.now());
    }

}

