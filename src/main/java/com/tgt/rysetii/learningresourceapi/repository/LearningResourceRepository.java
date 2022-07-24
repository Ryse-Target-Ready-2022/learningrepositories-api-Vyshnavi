package com.tgt.rysetii.learningresourceapi.repository;

import com.tgt.rysetii.learningresourceapi.entity.LearningResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningResourceRepository extends JpaRepository<LearningResource,Integer> {
}
