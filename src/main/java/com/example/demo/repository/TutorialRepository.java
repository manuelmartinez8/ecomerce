package com.example.demo.repository;

import com.example.demo.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    List<Tutorial> findByPublished(boolean published);
    Tutorial findByTitle(String title);

    List<Tutorial> findByTitleContaining(String title);

}
