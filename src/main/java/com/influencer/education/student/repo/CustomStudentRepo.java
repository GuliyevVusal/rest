package com.influencer.education.student.repo;

import com.influencer.education.student.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomStudentRepo {

    private final EntityManager em;

    public CustomStudentRepo(EntityManager em) {
        this.em = em;
    }

    public List<StudentEntity> getList() {
        final Query query = em.createQuery("select s.name, concat(s.name,' ',s.lastname ) from MyStudent s", StudentEntity.class);
        return query.getResultList();
    }


    @Transactional
    public void delete(Integer id) {
        final StudentEntity student = em.find(StudentEntity.class, id);
        em.remove(student);
    }

    @Transactional()
    public void insert(StudentEntity student) {
        em.persist(student);
    }


    public List<StudentEntity> getList(String name,
                                       String surname,
                                       String email,
                                       Integer universityId,
                                       Integer age) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<StudentEntity> cq = cb.createQuery(StudentEntity.class);
        final Root<StudentEntity> root = cq.from(StudentEntity.class);

        final List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        }
        if (surname != null && !surname.isEmpty()) {
            predicates.add(cb.like(root.get("surname"), "%" + surname + "%"));
        }
        if (email != null && !email.isEmpty()) {
            predicates.add(cb.like(root.get("email"), "%" + email + "%"));
        }
        if (age != null) {
            predicates.add(cb.equal(root.get("age"), age));
        }

        if (universityId != null) {
            predicates.add(cb.equal(root.get("university").get("id"), universityId));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));

        cq.where(and);
        cq.select(root);

        return em.createQuery(cq).getResultList();
    }
}
