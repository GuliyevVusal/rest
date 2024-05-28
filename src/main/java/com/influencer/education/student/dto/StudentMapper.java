package com.influencer.education.student.dto;


import com.influencer.education.student.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

     StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "lastname", target = "surname")
    StudentDTO toDto(StudentEntity entity);

    @Mapping(source = "surname", target = "lastname")
    StudentEntity toEntity(StudentDTO dto);

}
