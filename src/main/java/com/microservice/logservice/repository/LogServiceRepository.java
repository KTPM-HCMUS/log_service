package com.microservice.logservice.repository;

import com.microservice.logservice.model.LogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogServiceRepository extends JpaRepository<LogModel, Integer> {
}
