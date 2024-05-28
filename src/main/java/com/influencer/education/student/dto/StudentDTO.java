package com.influencer.education.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private Integer id;
    private String name;

    @JsonProperty("surname")
    private String surname;
    private String email;
    private Integer age;

    private UniversityDTO university;



}
