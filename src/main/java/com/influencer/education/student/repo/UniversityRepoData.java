package com.influencer.education.student.repo;

import com.influencer.education.student.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepoData extends JpaRepository<University, Integer> {


}
