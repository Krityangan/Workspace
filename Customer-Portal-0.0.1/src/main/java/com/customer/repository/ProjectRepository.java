package com.customer.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.datamodel.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

}
