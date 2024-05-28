package com.influencer.education.student.dto;

public class UniversityDTO {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public UniversityDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UniversityDTO setName(String name) {
        this.name = name;
        return this;
    }
}
