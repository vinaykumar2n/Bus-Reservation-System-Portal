package com.root.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.root.models.Feedback;

@Repository
public interface feedbackDao extends JpaRepository<Feedback, Integer>{

}
