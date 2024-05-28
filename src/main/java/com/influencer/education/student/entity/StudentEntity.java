package com.influencer.education.student.entity;

import jakarta.persistence.*;


@Entity(name = "MyStudent")
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "surname")
    private String lastname;
    private String email;
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "university_id", nullable = false)
    private University university;
    private String password;

    public Integer getId() {
        return id;
    }

    public StudentEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public StudentEntity setLastname(String surname) {
        this.lastname = surname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentEntity setAge(Integer age) {
        this.age = age;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public StudentEntity setUniversity(University university) {
        this.university = university;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public StudentEntity setPassword(String password) {
        this.password = password;
        return this;
    }
}
