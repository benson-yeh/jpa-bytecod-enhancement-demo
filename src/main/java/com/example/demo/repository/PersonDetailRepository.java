package com.example.demo.repository;

import com.example.demo.model.PersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailRepository extends JpaRepository<PersonDetail, Long> {}
