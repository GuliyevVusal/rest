package com.influencer.education.student.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "University")
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "university",targetEntity = StudentEntity.class
            ,cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<StudentEntity> students;

    public Integer getId() {
        return id;
    }

    public University setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(String name) {
        this.name = name;
        return this;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public University setStudents(List<StudentEntity> students) {
        this.students = students;
        return this;
    }
}

